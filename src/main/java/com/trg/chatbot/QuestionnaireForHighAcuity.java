package com.trg.chatbot;


import org.springframework.stereotype.Component;

@Component
public class QuestionnaireForHighAcuity extends Questionnaire{
	public QuestionnaireForHighAcuity() {
		mapOfProperties.put("0","type");
		mapOfProperties.put("1","touch");
		mapOfProperties.put("2","screensize");	
	}

}
