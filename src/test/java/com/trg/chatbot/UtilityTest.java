package com.trg.chatbot;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void test() {
		
		boolean actual=Utility.isNumeric("2");
		boolean expected=true;
		assertEquals(expected, actual);
		
	}

}
