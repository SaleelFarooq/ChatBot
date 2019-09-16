package com.trg.chatbot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class QuestionnaireTest {
	 
	MockData data=new MockData();
	@Test
	public void test_generateQuestionFromOptions() {
		Questionnaire ques=new Questionnaire();
		String expected="";
		expected += "we have "+"2" + " " + "name" + " to offer , which one do you want?\n";
		expected+="1"+". " +"saleel"+"\n";
		expected+="2"+". " +"venki"+"\n";
		List<String> ex=new ArrayList();
		ex.add("saleel");
		ex.add("venki");
		String actual=ques.generateQuestionFromOptions(ex, "name");
		assertEquals(expected, actual);
	}
	@Test
	public void test_setOptionList() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Questionnaire ques=new Questionnaire();
		List<String> actual=ques.setOptionList(data.provideMockList(), "screensize");
		List<String> expected=new ArrayList<String>();
		expected.add("9");
		expected.add("10");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_provideNextQuestion() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Questionnaire ques=new Questionnaire();
		String expected="";
		expected += "we have "+"2" + " " + "name" + " to offer , which one do you want?\n";
		expected+="1"+". " +"saleel"+"\n";
		expected+="2"+". " +"venki"+"\n";
		List<String> ex=new ArrayList();
		ex.add("saleel");
		ex.add("venki");
		String actual=ques.provideNextQuestion(ex, "name");
		assertEquals(expected, actual);
	}
}
