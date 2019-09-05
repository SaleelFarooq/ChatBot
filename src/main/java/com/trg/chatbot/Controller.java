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
	
	
	
	@GetMapping("/asknextquestion")
	public String askNextQuestion(@RequestParam(name="answer",required = false) String ans) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException  {
	return chatbot.user.generateNextQuestion(ans);
	}
	
	
	
	@GetMapping("/suggest")
	public String showSuggestedProducts() {
		return chatbot.user.suggest();
	}
	
	@GetMapping("/getdetails")
	public String getDetails(@RequestParam("name") String name,@RequestParam("location") String location,@RequestParam("beds") String beds) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		chatbot.user.populateUserDetails(name, location, beds);
		return "Hi "+name+ " , click on continue to chat..";
	}
	
	@GetMapping("/getfurtherdetails")
	public String getFurtherDetails(@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("shippingaddress") String shippingAddress,
			@RequestParam("centralPMS") String centralPMS,@RequestParam(name="additionalParameters" ,defaultValue = "") String additionalParams) {
		chatbot.user.populateFurtherDetails(email,phone,shippingAddress,centralPMS,additionalParams);
		return chatbot.alertSubscribers(chatbot.user);
	}
	
	@GetMapping("/alertsubscribers")
	public String alertSubscribers() {
		chatbot.alertSubscribers(chatbot.user);
		return "Subscribers are alerted";
	}
	
	@GetMapping("/addnewdevice")
	 public String  addNewdevice(@RequestParam("type") String type,@RequestParam("model") String model,
			 @RequestParam("screensize") String screensize,@RequestParam("touch") String touch,@RequestParam("masimorainbow") String masimoRainbow,
			 @RequestParam("spO2") String spo2,@RequestParam("cardiacoutput") String cardiacOutput) {
			int status = pmsService.addNewPms(type,model,screensize,touch,masimoRainbow,spo2,cardiacOutput);
			if(status>0)
					{return ("PMS added succesfully");}
			else
					{return ("Something happened , try again..");}
	}
	
	@GetMapping("/removedevice")
	public String deleteDevice(@RequestParam("type") String type,@RequestParam("model") String model) {
		int status = pmsService.deleteDevice(type,model);
		if(status==1)
				{return ("Deleted successfully");}
		else
				{return ("try deleting once again");}
	}
	
}
