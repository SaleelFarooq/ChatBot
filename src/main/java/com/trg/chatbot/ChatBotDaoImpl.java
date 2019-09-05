package com.trg.chatbot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChatBotDaoImpl implements ChatBotDao {
	int customerCount=1;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Pms> getAllList(){
		 return(jdbcTemplate.query("select * from pms",new PmsMapper()));
	}
	
	public int addNewDevice(Pms pms) {
		return jdbcTemplate.update("insert into pms values(?,?,?,?,?,?,?,?,?)",pms.type,pms.model,pms.screensize,pms.touch,pms.masimorainbow,pms.philipsSpo2,pms.cardiacoutput,pms.maxNoOfWaveforms,pms.leadECG12);
		
	}

	public int removeExistingDevice(String type, String model) {
		return jdbcTemplate.update("delete from pms where typename=? and modelno=?",type,model);
	}
	
	public int addNewCustomer(User user) {
		StringBuilder suggestionsMade= new StringBuilder();
		for(int i=0;i<user.suggestion.size();i++)
				{suggestionsMade.append(user.suggestion.get(i).getType()+" "+user.suggestion.get(i).getModel()+"   ");}
		String addons = "";
		if(user.centralPMS.equals("Yes"))
			addons+="Need Central PMS";
		addons+=user.additionalParams;
		String salesPersonId="253545";
		customerCount++;
		return jdbcTemplate.update("insert into customerforpms values(?,?,?,?,?,?,?,?,?,?)",customerCount,user.name,user.location,user.address,user.contactnumber,user.email,user.acuity,suggestionsMade,addons,salesPersonId);
	}
	
	public void refreshCustomerTable() {
		Logger.log("Refreshing customer table");
		jdbcTemplate.update("delete from customerforpms");
	}
}
