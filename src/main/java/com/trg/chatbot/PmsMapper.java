package com.trg.chatbot;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class PmsMapper implements RowMapper<Pms> {
		
		public Pms mapRow(ResultSet rs, int num) throws SQLException {
			Pms pms= new Pms();
			pms.setType(rs.getString(1));
			pms.setModel(rs.getString(2));
			pms.setScreensize(rs.getString(3));
			pms.setTouch(rs.getString(4));
			pms.setMasimorainbow(rs.getString(5));
			pms.setPhilipsSpo2(rs.getString(6));
			pms.setCardiacoutput(rs.getString(7));
			pms.setMaxNoOfWaveforms(rs.getString(8));
			pms.setLeadECG12(rs.getString(9));
			return pms;
		}

		
	}


