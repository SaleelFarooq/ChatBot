package com.trg.chatbot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class UserAssisterForLowAcuityTest {
	
	MockData data=new MockData();
	@Test
	public void test_setUpSuggestions() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		UserAssisterForLowAcuity user=new UserAssisterForLowAcuity();
		List<Pms> actual=user.setUpSuggestions(data.provideMockList(), "10",3 );
		List<Pms> expected=data.provideExpected();
		assertEquals(expected, actual);
	}
	@Test
	public void test_BypassQuestions() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		UserAssisterForLowAcuity user=new UserAssisterForLowAcuity();
	 boolean actual= user.bypassQuestions(3);
	 assertEquals(true, actual);
	 boolean actual1= user.bypassQuestions(0);
	 assertEquals(false, actual1);
	 boolean actual2= user.bypassQuestions(99);
	 assertEquals(false, actual1);
	}
	@Test
	public void test_setUpOptionList() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		UserAssisterForLowAcuity user=new UserAssisterForLowAcuity();
		List<String> actual=user.setUpOptionList(data.provideMockList(),2);
		List<String> expected=new ArrayList<String>();
		expected.add("9");
		expected.add("10");
		assertEquals(expected, actual);
	}
	@Test
	public void test_fn() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		UserAssisterForLowAcuity user=new UserAssisterForLowAcuity();
		List<String> expected=new ArrayList<String>();
		expected.add("9");
		expected.add("10");
		String actual=user.fn(data.provideMockList(), expected,2);
		String expected1="";
		expected1 += "we have "+"2" + " " + "screensize" + " to offer , which one do you want?\n";
		expected1+="1"+". " +"9"+"\n";
		expected1+="2"+". " +"10"+"\n";
		assertEquals(expected1, actual);
	}

}
