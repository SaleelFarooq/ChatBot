package com.trg;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.trg.chatbot.ChatBot;
import com.trg.chatbot.ChatBotDaoImpl;




@SpringBootApplication
public class MywebdemoApplication {

	public static void main(String[] args) throws JSONException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
		 ApplicationContext ctx =SpringApplication.run(MywebdemoApplication.class, args);
		 ChatBotDaoImpl dao1= ctx.getBean(ChatBotDaoImpl.class);
		 dao1.refreshCustomerTable();
		 ChatBot chatbot = ctx.getBean(ChatBot.class);
		 chatbot.setUpSubscribers();
		 
	}
}
