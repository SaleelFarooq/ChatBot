package com.trg.chatbot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class QuestionnaireForLowAcuity extends Questionnaire{
	protected static final String[] PARAM_ARRAY = {"philipsSpo2","cardiacoutput","masimorainbow"};
	private int[] flagArray= {0,0,0};
	public QuestionnaireForLowAcuity() {
		mapOfProperties.put("0","type");
		mapOfProperties.put("1","Combination of Parameters");
		mapOfProperties.put("2","touch");
		mapOfProperties.put("3","screensize");
	}
	
	private void setFlags(String response) {
		if(response.contains("Philips SpO2"))
			flagArray[0]=1;
		if(response.contains("Cardiac output"))
			flagArray[1]=2;
		if(response.contains("Masimo Rainbow"))
			flagArray[2]=1;
	}
	
	public List<String> setOptionsForParameters(){
		List<String> optionList=new ArrayList<>();
		optionList.add("Philips SpO2");
		optionList.add("Philips SpO2 , Cardiac output");
		optionList.add("Philips SpO2 , Masimo Rainbow");
		optionList.add("Philips SpO2 , Cardiac Output , Masimo Rainbow");
		return optionList;
	}
	
	public List<Pms> setSuggestionBasedOnParameters(List<Pms> availableProducts,String response) {
		List<Pms> result=new ArrayList<>();
		setFlags(response);
		for(int i=0;i<flagArray.length;i++)
				{if(flagArray[i]==1)
						{try {
							result=Utility.narrowDownSuggestions(availableProducts,PARAM_ARRAY[i],"yes");
						} catch (IllegalArgumentException | SecurityException e) {
							Logger.log("Exception happened");
						}
						try {
							result.addAll(Utility.narrowDownSuggestions(availableProducts,PARAM_ARRAY[i],"opt"));
						} catch (IllegalArgumentException | SecurityException e) {
							Logger.log("Exception happened");
						}}
				}
		return result;
	}
}
