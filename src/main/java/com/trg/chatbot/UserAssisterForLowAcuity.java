package com.trg.chatbot;

import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class UserAssisterForLowAcuity implements UserAssister{
	
	QuestionnaireForLowAcuity questionnaire=new QuestionnaireForLowAcuity();
	
	 
	
	@Override
	public List<Pms> setUpSuggestions(List<Pms> existingSuggestion, String currentResponse, int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		 if(countOfQuestion==1) {
			 return questionnaire.setSuggestionBasedOnParameters(existingSuggestion, currentResponse);
		 }
		 else
			 {return Utility.narrowDownSuggestions(existingSuggestion,questionnaire.getPropertyBeingAsked(countOfQuestion),currentResponse);
			 } 
	}

	@Override
	public boolean BypassQuestions(int n) {
		return (n==3);
	}

	@Override
	public List<String> setUpOptionList(List<Pms> existingSuggestion, int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if(countOfQuestion==0)
			{return questionnaire.setOptionsForParameters();
			}
	else
			{return questionnaire.setOptionList(existingSuggestion,questionnaire.getPropertyBeingAsked(countOfQuestion+1));
			} 
	}

	@Override
	public String fn(List<Pms> existingSuggestion,List<String> optionList,int countOfQuestion) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return questionnaire.provideNextQuestion(optionList,questionnaire.getPropertyBeingAsked(countOfQuestion+1));
	}

}
