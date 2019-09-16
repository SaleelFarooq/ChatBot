package com.trg.chatbot;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ChatBot{
	 
	@Autowired
	User user;
	static List<Subscriber> listOfSubscribers= new ArrayList<>();
	@Autowired
	SalesDepartment salesDepartment;
	
	public static void addSubscription(Subscriber subscriber) {
		listOfSubscribers.add(subscriber);
	}
	

	public ResponseReturned alertSubscribers(User user) {
		listOfSubscribers.get(0).saveDetails(user);
		ResponseReturned message = new ResponseReturned();
		message.content = "Your data have been passed to our Sales department";
		return message;
	}

	
	public void setUpSubscribers() {
		 addSubscription(salesDepartment);
	}
	
	
}
