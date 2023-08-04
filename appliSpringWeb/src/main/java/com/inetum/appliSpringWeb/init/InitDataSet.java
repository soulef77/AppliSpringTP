package com.inetum.appliSpringWeb.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoOperation;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;

@Component
//@Profile("init")
public class InitDataSet {

	@Autowired
	private DaoCompte daoCompteJpa;
	
	@Autowired
	private DaoOperation daoOperationJpa;
	
	@PostConstruct
	public void initData() {
		Compte compteAa = daoCompteJpa.insert(new Compte(null,"compteAa",1000.0));


		Operation op1CompteA = daoOperationJpa.insert(
	    		new Operation(null,-3.2 , "achat bonbons" , new Date() , compteAa));
		
		
		daoCompteJpa.insert(new Compte(null,"sgSG",  500.0));
		daoCompteJpa.insert(new Compte(null,"caCA", 9000.0));
	}
	
}
