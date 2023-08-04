package com.inetum.appliSpringWeb.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliSpringWeb.entity.Compte;


@SpringBootTest
public class TestCompteDao {

	Logger logger= LoggerFactory.getLogger(TestCompteDao.class);
	@Autowired
	private DaoCompte daoCompteJpa;
	
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
	public void testQueries() {
			
		daoCompteJpa.insert(new Compte(null,"sg", 1000.0));
		daoCompteJpa.insert(new Compte(null,"ca", 10000.0));
		daoCompteJpa.insert(new Compte(null,"sg", 8000.0));
		daoCompteJpa.insert(new Compte(null,"ca", 90000.0));
		
		List<Compte>compteAyanPourSoldeMini = daoCompteJpa.findBySoldeMini(300.0);
		assertTrue(compteAyanPourSoldeMini.size() >= 2);
		logger.debug("numero de compte avec solde min"+ compteAyanPourSoldeMini.toString());
		
		List<Compte>compteAyanPourSoldeMax = daoCompteJpa.findBySoldeMax(30000.0);
		logger.debug("numero de compte avec solde max"+ compteAyanPourSoldeMax.toString());
	}
}
