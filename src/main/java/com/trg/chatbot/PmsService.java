package com.trg.chatbot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PmsService {
	
	@Autowired  
	private ChatBotDao databaseAccessobject;
	
	public  List<Pms> retrieveAllPMS() {
		return (databaseAccessobject.getAllList());
	}

    public int addNewPms(String type,String model,String screenSize,String touch,String masimoRainbow,String spO2,
    		String cardiacOutput) {
    	Pms pms = new Pms();
		pms.setType(type);
		pms.setModel(model);
		pms.setScreensize(screenSize);
		pms.setTouch(touch);
		pms.setMasimorainbow(masimoRainbow);
		pms.setPhilipsSpo2(spO2);
		pms.setCardiacoutput(cardiacOutput);
		pms.setMaxNoOfWaveforms("8");
		pms.setLeadECG12("yes");
    	return (databaseAccessobject.addNewDevice(pms));
    }
 
    public int deleteDevice(String type,String model) {
    	return databaseAccessobject.removeExistingDevice(type, model);
    }
	
}
