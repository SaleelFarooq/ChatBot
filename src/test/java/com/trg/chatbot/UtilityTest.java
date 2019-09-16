package com.trg.chatbot;

import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class UtilityTest {
       
	  MockData data=new MockData();
      
			@Test
			public void test_narrowdown() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException {
				Utility user=new Utility();
				List<Pms> expected=data.provideExpected();
				List<Pms> MockList=data.provideMockList();
				
			List<Pms> actual=user.narrowDownSuggestions(MockList, "type", "Efficia");
			
			assertEquals(expected, actual);
			}
			
	
	@Test
	public void test_isNumeric() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException {
		Utility user=new Utility();
		boolean actual=user.isNumeric("9");
		assertEquals(true, actual);
		boolean actual1=user.isNumeric("a");
		assertEquals(false, actual1);
		boolean actual2=user.isNumeric(",");
		assertEquals(false, actual2);
		boolean actual3=user.isNumeric("-");
		assertEquals(false, actual3);
		boolean actual4=user.isNumeric("a1");
		assertEquals(false, actual4);
	}

}
