package com.trg.chatbot;

import java.util.List;

public interface ChatBotDao {
	public List<Pms> getAllList();
	public int addNewDevice(Pms pms);
	public int removeExistingDevice(String type,String model);
	public int addNewCustomer(User user);
}
