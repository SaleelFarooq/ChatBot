package com.trg.chatbot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductList {
 
 @Autowired
private  PmsService pmsService;

 
 	public List<Pms> listAllPMS(){
 		return (pmsService.retrieveAllPMS());
 	} 	
}
