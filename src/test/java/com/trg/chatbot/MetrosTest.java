package com.trg.chatbot;

import org.junit.Test;

import junit.framework.Assert;

public class MetrosTest {

	@Test
	public void test_true() {
		Metros metro=new Metros();
		boolean met=metro.isMetro("bangalore");
		Assert.assertEquals(true, met);
		boolean met1=metro.isMetro("delhi");
		Assert.assertEquals(true, met1);
		boolean met2=metro.isMetro("bengaluru");
		Assert.assertEquals(true, met2);
		boolean met3=metro.isMetro("mumbai");
		Assert.assertEquals(true, met3);
		boolean met4=metro.isMetro("kolkatha");
		Assert.assertEquals(true, met4);
		boolean met5=metro.isMetro("pune");
		Assert.assertEquals(true, met5);
		boolean met6=metro.isMetro("hyderabad");
		Assert.assertEquals(true, met6);
		boolean met7=metro.isMetro("BANGALORE");
		Assert.assertEquals(true, met7);
		boolean met8=metro.isMetro("PUNE");
		Assert.assertEquals(true, met8);
		boolean met9=metro.isMetro("Pune");
		Assert.assertEquals(true, met9);
	}

	
	@Test
	public void test_false() {
		Metros metro=new Metros();
		boolean met=metro.isMetro("bangalore45");
		Assert.assertEquals(false, met);
		boolean met1=metro.isMetro("newdelhi");
		Assert.assertEquals(false, met1);
		boolean met2=metro.isMetro("punee");
		Assert.assertEquals(false, met2);
		boolean met3=metro.isMetro("bengalore");
		Assert.assertEquals(false, met3);
		boolean met4=metro.isMetro("COLKATTA");
		Assert.assertEquals(false, met4);
		boolean met5=metro.isMetro("HAIDERABAD");
		Assert.assertEquals(false, met5);
	}
}
