package com.trg.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesDepartment implements Subscriber{	
	@Autowired
	ChatBotDao dataAccesObject;
	
	@Override
	public void saveDetails(User user) {
		 int status=dataAccesObject.addNewCustomer(user);
		 if(status==1)
			{Logger.log("Your details have been forwarded to our sales department ..");
			}
	else
		{Logger.log("wait.. your details are being sent..");
		saveDetails(user);
		}
	}
	
		
	}


