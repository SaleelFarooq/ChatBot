package com.trg.chatbot;

import java.util.ArrayList;
import java.util.List;

public class Utility {
	Utility() {
		super();
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	public static List<Pms> narrowDownSuggestions(List<Pms> list1,String property,String valueOfProperty) {
    	 List<Pms> result = new ArrayList<>();
 		int lengthOfList=list1.size();
 		for(int i=0;i<lengthOfList;i++)
 					{try {
						if((Pms.class.getDeclaredField(property).get(list1.get(i))).equals(valueOfProperty))
								result.add(list1.get(i));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException e) {
						Logger.log("Exceptions happened");
					}
 					}
 		return result;
     }

}
