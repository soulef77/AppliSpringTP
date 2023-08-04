package com.inetum.appliSpringWeb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;


@SpringBootTest
//@ActiveProfiles("oracle")
public class TestServiceCompte {

	
	Logger logger= LoggerFactory.getLogger(TestServiceCompte.class);
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	/*@Test
	public void testGrandTransfert() {
		Compte cptA = serviceCompte.sauvegarderCompte(new Compte(null,"compteA", 50.00));
		Compte cptB = serviceCompte.sauvegarderCompte(new Compte(null,"compteB", 250.00));
				
		logger.trace("avant bon  virement: cptA = " +cptA.getSolde()+ "et cptB = " +cptB.getSolde());
		try {
			serviceCompte.transferer(2000,cptA.getNumero(), cptB.getNumero());
			
			Compte cptA_apres = serviceCompte.rechercherCompteParNumero(cptA.getNumero());
			Compte cptB_apres = serviceCompte.rechercherCompteParNumero(cptB.getNumero());
			
			logger.trace("après bon  virement: cptA = " +cptA_apres.getSolde()+ "et cptB = " +cptB_apres.getSolde());
			assertEquals(cptA.getSolde() - 20, cptA_apres.getSolde(), 0.001);
			assertEquals(cptB.getSolde() + 20, cptB_apres.getSolde(), 0.001);
			
			
		} catch (BankException e) {
			// TODO Auto-generated catch block
			logger.debug("trop grand decouvert");
		}
		*/
				

	
	
	@Test
	public void testBonTransfert(){
		
			Compte cptA = serviceCompte.sauvegarderCompte(new Compte(null,"compteA", 50.00));
			Compte cptB = serviceCompte.sauvegarderCompte(new Compte(null,"compteB", 250.00));
					
			logger.trace("avant bon  virement: cptA = " +cptA.getSolde()+ "et cptB = " +cptB.getSolde());
			serviceCompte.transferer(20,cptA.getNumero(), cptB.getNumero());
			Compte cptA_apres = serviceCompte.rechercherCompteAvceOperationsParNumero(cptA.getNumero());
			Compte cptB_apres = serviceCompte.rechercherCompteAvceOperationsParNumero(cptB.getNumero());
			
			logger.trace("après bon  virement: cptA = " +cptA_apres.getSolde()+ "et cptB = " +cptB_apres.getSolde());
			assertEquals(cptA.getSolde() - 20, cptA_apres.getSolde(), 0.001);
			assertEquals(cptB.getSolde() + 20, cptB_apres.getSolde(), 0.001);
			
			logger.trace("liste de operations de cptA_apre");
			for(Operation op: cptA_apres.getOperations()) {
				logger.trace("\t" + op.toString());
			}
		
				
}
	
	
	@Test
	public void testMauvaisTransfert() {
		Compte cptA = serviceCompte.sauvegarderCompte(new Compte(null,"compteAA", 40.00));
		Compte cptB = serviceCompte.sauvegarderCompte(new Compte(null,"compteBB", 550.00));
		logger.trace("avant mauvais  virement: cptA = " +cptA.getSolde()+ "et cptB = " +cptB.getSolde());
		try {
			serviceCompte.transferer(20,cptA.getNumero(), -2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.trace("exception normale en cas de mauvais virement " + e.getMessage());
		}
		Compte cptA_apres = serviceCompte.rechercherCompteParNumero(cptA.getNumero());
		Compte cptB_apres = serviceCompte.rechercherCompteParNumero(cptB.getNumero());
		
		logger.trace("après mauvaus  virement: cptA = " +cptA_apres.getSolde()+ "et cptB = " +cptB_apres.getSolde());
		
		assertEquals(cptA.getSolde() , cptA_apres.getSolde(), 0.001);
		assertEquals(cptB.getSolde() , cptB_apres.getSolde(), 0.001);
		
}
}
