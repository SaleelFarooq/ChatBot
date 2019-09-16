package com.trg.chatbot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mock;

public class UserTest {
	
	  MockData data=new MockData();
     
		@Test
		public void test_decideAcuity() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException {
			User user=new User();
			String actual=user.decideAcuity("pune", 234);
			  assertEquals("high", actual);
			  String actual1=user.decideAcuity("pune", 23);
			  assertEquals("low", actual1);
			  String actual2=user.decideAcuity("calicut", 23);
			  assertEquals("low", actual2);
			  String actual3=user.decideAcuity("calicut", 234);
			  assertEquals("low", actual3);
		}
		@Test
		public void test_yesorno() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException {
			User user=new User();
			List<String> expected=new ArrayList<>();
			expected.add("Yes");
		    expected.add("No");
			List<String> actual=new ArrayList<>();
			actual=user.getYesORNoList();
			assertEquals(expected, actual);
		}
	
		}
		
