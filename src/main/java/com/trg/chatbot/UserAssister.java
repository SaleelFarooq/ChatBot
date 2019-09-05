package com.trg.chatbot;

import java.util.List;

public interface UserAssister {

	public List<Pms> setUpSuggestions(List<Pms> existingSuggestion,String currentResponse,int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public boolean BypassQuestions(int n);
	public List<String> setUpOptionList(List<Pms> existingSuggestion,int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public String fn(List<Pms> existingSuggestion,List<String> optionList,int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
}
