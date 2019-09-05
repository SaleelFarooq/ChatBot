package com.trg.chatbot;


import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class User {
	 String name;
     String location;
     int nofbeds;
     String acuity;
     String response;
     List<Pms> suggestion;
     String centralPMS;
     String additionalParams;
     String contactnumber;
     String email;
     String address;
     List<String> responseSequence;
     String lastAskedQuestion="";
     private int n=0;
     private List<String> optionList=new ArrayList<String>();
     @Autowired
     ProductList productList;
     
     UserAssister userAssister;
     public void seUpUserAssister(String acuity) {
    	 if(acuity.equals("low"))
    		 	this.userAssister=new UserAssisterForLowAcuity();
    	 else
    		 this.userAssister=new UserAssisterForHighAcuity();
     }
     
     User(){
     }
    
     
     public void setCountOfQnToZero() {
    	 this.n=0;
    	 this.suggestion=productList.listAllPMS();
     }
     
     
   
     
    public String askOnceAgain() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	return ("What you have entered is not a valid option\n"+this.lastAskedQuestion);
    }
    
    private boolean checkIfResponseIsInvalid(String ans) {
    	return (!(Utility.isNumeric(ans)) || (Integer.parseInt(ans) >this.optionList.size()));
    }
    
    private String setResponse(String ans) {
    	if(this.n==0)
    		return this.response;
    	else 
    		return this.optionList.get(Integer.parseInt(ans)-1);
    }
     
     public String generateNextQuestion(String ans) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	 String question="";
    	 if(this.n!=0 && checkIfResponseIsInvalid(ans))
			 {return askOnceAgain();
			 }
    	 this.response=setResponse(ans);
    	 this.suggestion=userAssister.setUpSuggestions(this.suggestion,this.response,this.n);
   
    	 if(userAssister.BypassQuestions(this.n))
    		 	return "I have arrived at a suggestion for you";
    
    	 this.optionList=userAssister.setUpOptionList(this.suggestion,this.n);
    	 
    	 question=userAssister.fn(this.suggestion,this.optionList,this.n);
    	 this.n++;
    	 this.lastAskedQuestion=question;
    	 return question;
     }
     
     
    
     
     public static String decideAcuity(String location,int beds) {
    	 String acuity="low";
    	 if(location!=null && Metros.isMetro(location) && (beds>200))
    		 {acuity="high";}
    	 return acuity;
     }
     
     public List<String> getYesORNoList(){
    	 List<String> result = new ArrayList<>();
    	 result.add("Yes");
    	 result.add("No");
    	 return result;
     }
     
     public String suggest() {
    	 String suggestion="";
    	 if(this.suggestion.size()==1)
    		 	suggestion="The product that is suitable for you is \n";
    	 else
    		 suggestion="Our products those will suit your recquirements are \n";
    	 for(int i=0;i<this.suggestion.size();i++)
    		 suggestion+=this.suggestion.get(i).type.toUpperCase()+" "+this.suggestion.get(i).model+"\n";
    	 this.n=5;
    	 optionList=getYesORNoList();
    	 return (suggestion);
     }
     
     public void populateUserDetails(String name,String location,String beds) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	 this.name=name;
    	 this.location=location;
    	 this.nofbeds=Integer.parseInt(beds);
    	 this.acuity=decideAcuity(location,nofbeds);
     	 this.suggestion=productList.listAllPMS();
   	    if(this.acuity.equals("low"))
   	    	response="Efficia";
   	    else
   	    	response="Intellivue";
   	    seUpUserAssister(this.acuity);
     }
     
     public void populateFurtherDetails(String email,String phone,String shippingAddress,String centralPMS,String additionalParams) {
    	 this.email=email;
    	 this.contactnumber=phone;
    	 this.address=shippingAddress;
    	 this.centralPMS=centralPMS;
    	 this.additionalParams=additionalParams;
     }
     

	
	
}
