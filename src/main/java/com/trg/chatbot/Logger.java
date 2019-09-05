package com.trg.chatbot;

import org.springframework.stereotype.Controller;

@Controller
public class Logger {
	
	private Logger() {
		super();
	}

	public static void log(Object o) {
		System.out.println((String) o);
	}
}
