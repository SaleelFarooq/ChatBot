package com.trg.chatbot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

public class QuestionnaireForLowAcuityTest {

	MockData data=new MockData();
	 
	@Test
	public void test_setOptionsForParameters() {
		QuestionnaireForLowAcuity ques=new QuestionnaireForLowAcuity();
	 List<String>actual= ques.setOptionsForParameters();
	 List<String> optionList=new ArrayList<String>();
		optionList.add("Philips SpO2");
		optionList.add("Philips SpO2 , Cardiac output");
		optionList.add("Philips SpO2 , Masimo Rainbow");
		optionList.add("Philips SpO2 , Cardiac Output , Masimo Rainbow");
    assertEquals(optionList, actual);
	  
	}
	@Test
	public void test_setSuggestionBasedOnParameters() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		QuestionnaireForLowAcuity ques=new QuestionnaireForLowAcuity();
	   List<Pms> actual=ques.setSuggestionBasedOnParameters(data.provideMockList(), "Philips SpO2");

}}
