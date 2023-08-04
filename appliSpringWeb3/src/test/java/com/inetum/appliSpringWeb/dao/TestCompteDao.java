package com.inetum.appliSpringWeb.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;
import com.inetum.appliSpringWeb.entity.Operation;


@SpringBootTest
@ActiveProfiles("oracle")
public class TestCompteDao {

	Logger logger= LoggerFactory.getLogger(TestCompteDao.class);
	@Autowired
	private DaoCompte daoCompteJpa;
	
	@Autowired
	private DaoOperation daoOperationJpa;
	
	
	@Autowired
	private DaoCustomer daoCustomerJpa;
	
//	@Test
//	public void experimentationPersistantDetache() {
//		Compte compteCc = daoCompteJpa.insert(new Compte(null,"sg", 50.0));
//		Compte compteCCReluDetache = daoCompteJpa.findById(compteCc.getNumero());
//		logger.debug("compteCcReluDetache = "+ compteCCReluDetache);
//		compteCCReluDetache.setSolde(compteCCReluDetache.getSolde() - 20);
//		Compte compteCcEncoreRelu = daoCompteJpa.findById(compteCc.getNumero());
//		logger.debug("compteCCcEncoreRelu= " + compteCcEncoreRelu);
//	
//		
//		Compte compteCc2 = daoCompteJpa.insert(new Compte(null,"LaPoste", 50.0));
//		Compte compteCC2ReluDetache = daoCompteJpa.findById(compteCc2.getNumero());
//		logger.debug("compteCcReluDetache = "+ compteCC2ReluDetache);
//		//daoCompteJpa.trouverEtDebiter(compteCc2.getNumero(), 20);
//		compteCC2ReluDetache.setSolde(compteCC2ReluDetache.getSolde() - 20);
//		Compte compteCc2EncoreRelu = daoCompteJpa.findById(compteCc2.getNumero());
//		logger.debug("compteCCc2EncoreRelu= " + compteCc2EncoreRelu);
//	}
	
		
	@Test
	public void testCompteAvecOperations() {
		Compte compteAa = daoCompteJpa.save(new Compte(null,"compteAa",1000.0));
		
		Compte compteBb = daoCompteJpa.save(new Compte(null,"compteBb",1000.0));


		Operation op1CompteA = daoOperationJpa.save(
	    		new Operation(null,-3.2 , "achat bonbons" , new Date() , compteAa));
		
		daoCompteJpa.save(new Compte(null,"sgSG",  500.0));
		
		//Compte compteARelu = daoCompteJpa.findById(compteAa.getNumero()).orElse(null);
		/*Compte compteARelu = daoCompteJpa.findByWithOperations(compteAa.getNumero()).orElse(null);
		logger.debug("compteARelu " + compteARelu.toString());
		logger.debug("operations du compteARelu ");
		for(Operation op: compteARelu.getOperations()) {
			logger.debug("\t" + op.toString());
		}
		*/
		Compte compteCc = daoCompteJpa.save(new Compte(null,"compteCc",1000.0));
		
		Compte compteDd = daoCompteJpa.save(new Compte(null,"compteDd",1000.0));

		
		Customer customer1= daoCustomerJpa.save(new Customer(null, "sissi","soussou","ok"));

		compteCc.setCustomer(customer1);
		compteDd.setCustomer(customer1);
		daoCompteJpa.save(compteCc);
		daoCompteJpa.save(compteDd);
		
		daoCustomerJpa.save(customer1);
		
		List<Compte> compteAssocieCustomer= daoCompteJpa.findByCustomerId(customer1.getId());
		
		logger.debug("compteARelu2 " + compteAssocieCustomer);
		logger.debug("customer du compte ");
		//for(Customer op2:compteAssocieCustomer.getCustomer()) {
			//logger.debug("\t" + compteAssocieCustome);
		//}
		
	}
	
	@Test
	public void testQueries() {
			
		daoCompteJpa.save(new Compte(null,"sg", 1000.0));
		daoCompteJpa.save(new Compte(null,"ca", 10000.0));
		daoCompteJpa.save(new Compte(null,"sg", 8000.0));
		daoCompteJpa.save(new Compte(null,"ca", 90000.0));
		
		List<Compte>compteAyanPourSoldeMini = daoCompteJpa.findBySoldeGreaterThanEqual(300.0);
		assertTrue(compteAyanPourSoldeMini.size() >= 2);
		logger.debug("numero de compte avec solde min"+ compteAyanPourSoldeMini.toString());
		
		List<Compte>compteAyanPourSoldeMax = daoCompteJpa.findBySoldeLessThanEqual(30000.0);
		logger.debug("numero de compte avec solde max"+ compteAyanPourSoldeMax.toString());
	}
}
