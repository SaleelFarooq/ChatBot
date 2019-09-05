package com.trg.chatbot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
@Controller
public class Metros {
	private Metros() {
		super();
	}
	
	protected static Set<String> list = new HashSet<>();
	static {
		list.add("delhi");
		list.add("bengaluru");
		list.add("bangalore");
		list.add("mumbai");
		list.add("kolkatha");
		list.add("pune");
		list.add("hyderabad");
		list.add("chennai");
		list.add("ahmedabad");
		list.add("surat");
		list.add("kanpur");
	}
	
	

	public static boolean isMetro(String location) {
		return (list.contains(location.toLowerCase()));
	}
	
	
}
