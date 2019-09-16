package com.trg.chatbot;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
@Component
public class Questionnaire {
	  Map<String,String> mapOfProperties=new HashMap<>();
	
	public  String getPropertyBeingAsked(int n) {
		String key=String.valueOf(n);
		return mapOfProperties.get(key);
	}
	
	
	public String generateQuestionFromOptions(List<String> options,String propertyBeingAsked) {
		StringBuilder question = new StringBuilder();
		question.append("we have "+options.size() + " " + propertyBeingAsked + " to offer , which one do you want?\n");
		for(int i=0;i<options.size();i++)
				{question.append((i+1)+". " + options.get(i)+"\n");
				}
		return question.toString();
	}
	
	public String provideNextQuestion(List<String> availableOptions,String propertyBeingAsked)  {
		return generateQuestionFromOptions(availableOptions,propertyBeingAsked);
	}
	
	public List<String> setOptionList(List<Pms> availabList,String property)  {
 		Field fld = null;
		try {
			fld = Pms.class.getDeclaredField(property);
		} catch (NoSuchFieldException | SecurityException e) {
			Logger.log("Exceptions happened");
		}
 		Set<String> setOfOptions= new HashSet<>();
 		List<String> result=new ArrayList<>();
 		for(int i=0;i<availabList.size();i++)
 				{try {
					setOfOptions.add((String )fld.get(availabList.get(i)));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					Logger.log("Exceptions happened");
				}
 				}
 		for(String item : setOfOptions)
 			result.add(item);
 		return result;
 		
 	}
}
