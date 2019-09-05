package com.trg.chatbot;

import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class UserAssisterForHighAcuity implements UserAssister{
	
	QuestionnaireForHighAcuity questionnaire=new QuestionnaireForHighAcuity();

	
	
	@Override
	public List<Pms> setUpSuggestions(List<Pms> existingSuggestion, String currentResponse, int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return Utility.narrowDownSuggestions(existingSuggestion,questionnaire.getPropertyBeingAsked(countOfQuestion),currentResponse); 
	}

	@Override
	public boolean BypassQuestions(int n) {
		return (n==2); 
	}

	@Override
	public List<String> setUpOptionList(List<Pms> existingSuggestion, int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return questionnaire.setOptionList(existingSuggestion,questionnaire.getPropertyBeingAsked(countOfQuestion+1)); 
	}

	

	@Override
	public String fn(List<Pms> existingSuggestion, List<String> optionList, int countOfQuestion)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		 return questionnaire.provideNextQuestion(optionList,questionnaire.getPropertyBeingAsked(countOfQuestion+1));
	}

}
