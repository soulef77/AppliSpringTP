package com.inetum.appliSpringjpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.appliSpringjpa.entity.Compte;
import com.inetum.appliSpringjpa.entity.CompteEpargne;
import com.inetum.appliSpringjpa.entity.Operation;


@SpringBootTest
public class TestOperationDao {

	Logger logger= LoggerFactory.getLogger(TestOperationDao.class);
	@Autowired
	private DaoOperation daoOperationJpa;
	
	@Autowired
	private	DaoCompte daoCompteJpa;
	
	@Autowired
	private	DaoCompteEpargne daoCompteEpargneJpa;
	
	@Test
	public void testSensSecondaire() {
		
		/*Compte compteAA = new Compte(null,"lapose", 200.0);
		
		Operation op1 = new Operation(null, -3.2, "achat fleurs", new Date());
		op1.setCompte(compteAA);
		compteAA.addOperation(op1);
		compteAA.addOperation(new Operation(null, -2.2, "achat roses", new Date()));
		 
		daoCompteJpa.insert(compteAA);
		*/
				
		Compte compteAA = daoCompteJpa.insert(new Compte(null,"lapose", 200.0));
		Operation op1 = new Operation(null, -3.2, "achat fleurs", new Date());
		op1.setCompte(compteAA);
		daoOperationJpa.insert(op1);
		
		Operation op2 = new Operation(null, -7.3," achat roses", new Date());
		op2.setCompte(compteAA);
		daoOperationJpa.insert(op2);
		
		
		CompteEpargne compteEpargne =  daoCompteEpargneJpa.insert(new CompteEpargne(null,"creditAgticole",52.0,3.2));
	}
	
	@Test
	public void testCompteEtOperaton() {
	
		Compte compteA = daoCompteJpa.insert(new Compte(null,"lapose", 200.0));
		Compte compteB = daoCompteJpa.insert(new Compte(null,"sg", 300.0));
		
		Operation op1CompteA = daoOperationJpa.insert(new Operation(null, -30.2, "achat livres", new Date(), compteA));
		Operation op1CompteB = daoOperationJpa.insert(new Operation(null, -50.2, "achat dvd", new Date(), compteB));
		Operation op2CompteA = daoOperationJpa.insert(new Operation(null, -0.2, "achat jouets", new Date(), compteA));
		Operation op2CompteB = daoOperationJpa.insert(new Operation(null, -30.2, "achat cd", new Date(), compteB));
	
		Operation op1CompteARelu = daoOperationJpa.findById(op1CompteA.getIdOp());
		logger.debug("op1);CompteARelu= " +op1CompteA);
		
		assertEquals(-30.2, op1CompteARelu.getMontant(),0.00001);
		
		Compte compteARelu = daoCompteJpa.findCompteWithOperationById(compteA.getNumero());
		
		logger.debug("operations du compteA:");
    	for(Operation op : compteARelu.getOperations() ) {
    		logger.debug("\t" + op.toString());
    	}
	}
}
	

