package com.trg.chatbot;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	ChatBot chatbot;
	@Autowired
	PmsService pmsService;
	
	@GetMapping(value = "/ask" ,produces = "application/json")
	public ResponseReturned askQuestions(@RequestParam(name="answer",required = false) String ans)  {
	chatbot.user.setCountOfQnToZero();
	ResponseReturned qn;
		if(ans==null)	
				{
				qn=chatbot.user.generateNextQuestion(ans);}
			else 
				{String[] arrOfStr = ans.split(","); 
				qn=chatbot.user.generateNextQuestion("");
				for(int i=0;i<arrOfStr.length;i++)
						{
						qn=chatbot.user.generateNextQuestion(arrOfStr[i]);
						}
				}
		return qn;	
		}
		
	
	
	
	
	@GetMapping(value = "/suggest" , produces = "application/json")
	public  ResponseReturned showSuggestedProducts() {
		return chatbot.user.suggest();
	}
	
	@GetMapping(value = "/getdetails", produces = "application/json")
	public ResponseReturned getDetails(@RequestParam("name") String name,@RequestParam("location") String location,@RequestParam("beds") String beds) {
		try {
			chatbot.user.populateUserDetails(name, location, beds);
		} catch (IllegalArgumentException | SecurityException e) {
			Logger.log("Exceptions");
		}
		ResponseReturned welcomeMessage = new ResponseReturned();
		welcomeMessage.content="Hi "+name+ " , click on continue to chat..";
		 return welcomeMessage;
	}
	
	@GetMapping(value = "/getfurtherdetails" , produces = "application/json")
	public ResponseReturned getFurtherDetails(@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("shippingaddress") String shippingAddress,
			@RequestParam("centralPMS") String centralPMS,@RequestParam(name="additionalParameters" ,defaultValue = "") String additionalParams) {
		chatbot.user.populateFurtherDetails(email,phone,shippingAddress,centralPMS,additionalParams);
		return chatbot.alertSubscribers(chatbot.user);
	}
	

	
	@GetMapping(value = "/addnewdevice" , produces = "application/json")
	 public ResponseReturned  addNewdevice(@RequestParam("type") String type,@RequestParam("model") String model,
			 @RequestParam("screensize") String screensize,@RequestParam("touch") String touch,@RequestParam("masimorainbow") String masimoRainbow,
			 @RequestParam("spO2") String spo2,@RequestParam("cardiacoutput") String cardiacOutput) {
			int status = pmsService.addNewPms(type,model,screensize,touch,masimoRainbow,spo2,cardiacOutput);
			ResponseReturned message = new ResponseReturned();
			if(status>0)
					{message.content="PMS added succesfully";
					}
			else
					{message.content="Something happened , try again..";}
			return message;
	}
	
	@GetMapping(value = "/removedevice" , produces = "application/json")
	public ResponseReturned deleteDevice(@RequestParam("type") String type,@RequestParam("model") String model) {
		ResponseReturned message = new ResponseReturned();
		int status = pmsService.deleteDevice(type,model);
		if(status==1)
				{message.content="Deleted successfully";}
		else
				{message.content="try deleting once again";}
		return message;
	}
	
}
