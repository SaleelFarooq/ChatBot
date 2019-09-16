package com.trg.chatbot;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
public class PmsMapperTest {

	 @Mock
	 private ResultSet resultSet;
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws SQLException {
		 Mockito.when(resultSet.getString(1)).thenReturn("Efficia");
	     Mockito.when(resultSet.getString(2)).thenReturn("CM10");
	     Mockito.when(resultSet.getString(3)).thenReturn("10");
	     Mockito.when(resultSet.getString(4)).thenReturn("opt");
	     Mockito.when(resultSet.getString(5)).thenReturn("no");
	     Mockito.when(resultSet.getString(6)).thenReturn("opt");
	     Mockito.when(resultSet.getString(7)).thenReturn("no");
	     Mockito.when(resultSet.getString(8)).thenReturn("8");
	     Mockito.when(resultSet.getString(9)).thenReturn("no");
		PmsMapper pmsmapper=new PmsMapper();
	 Pms actual=pmsmapper.mapRow(resultSet, 2);
	 Assert.assertNotNull(actual);
     Assert.assertEquals("Efficia", actual.getType());
     Assert.assertEquals("CM10", actual.getModel());
     Assert.assertEquals("10", actual.getScreensize());
     Assert.assertEquals("opt", actual.getTouch());
     Assert.assertEquals("no", actual.getMasimorainbow());
     Assert.assertEquals("opt", actual.getPhilipsSpo2());
     Assert.assertEquals("no", actual.getCardiacoutput());
     Assert.assertEquals("8", actual.getMaxNoOfWaveforms());
     Assert.assertEquals("no", actual.getLeadECG12());
     
	}

}
