package com.trg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.trg.chatbot.ChatBot;
import com.trg.chatbot.ChatBotDaoImpl;
import com.trg.chatbot.Logger;




@SpringBootApplication
public class MywebdemoApplication {

	public static void main(String[] args) {
		try {
			ApplicationContext ctx =SpringApplication.run(MywebdemoApplication.class, args);
			 ChatBotDaoImpl dao1= ctx.getBean(ChatBotDaoImpl.class);
			 dao1.refreshCustomerTable();
			 ChatBot chatbot = ctx.getBean(ChatBot.class);
			 chatbot.setUpSubscribers(); 
			}
			catch(IllegalArgumentException e) {
				Logger.log("IllegalArgumentException1");
			}
			catch(SecurityException e) {
				Logger.log("SecurityException1");
			}
			 
	 
	}
}
