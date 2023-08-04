package com.inetum.appliSpringjpa.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inetum.appliSpringjpa.entity.Adresse;
import com.inetum.appliSpringjpa.entity.Client;
import com.inetum.appliSpringjpa.entity.Compte;
import com.inetum.appliSpringjpa.entity.Personne;


@SpringBootTest
public class TestClientDao {

	Logger logger= LoggerFactory.getLogger(TestClientDao.class);
	
		
	@Autowired
	private DaoClient daoClientJpa;
	
	@Autowired
	private DaoCompte daoCompteJpa;
	
	@Autowired
	private DaoPersonne daoPersonneJpa;
	
	@Test
	public void testClientEtCompte() {
		
		Personne personne1 = daoPersonneJpa.insert(new Personne(null,"luc","sky"));
		logger.debug("employe1= " + personne1);
					
		Client client1 = new Client(null, "pierre","paul");
		client1.setAdressePrincipale(new Adresse(null, "cour du lion", 75018, "paris"));
		client1 = daoClientJpa.insert(client1);
		
		logger.debug("client1eTAdresse " + client1.toString());
		Client client2 = daoClientJpa.insert(new Client(null,"sarah","lian"));
		Client client3 = daoClientJpa.insert(new Client(null," sana","soussou"));
		Client client4 = daoClientJpa.insert(new Client(null,"jean","pierre" ));
	
		Compte compteA = new Compte(null,"lapose", 200.0 );
		compteA.getClients().add(client1);
		compteA.getClients().add(client2);
		compteA = daoCompteJpa.insert(compteA);
		Compte compteB = new Compte(null,"sg", 300.0);
		compteB.getClients().add(client1);
		compteB = daoCompteJpa.insert(compteB);
		
		//client1= daoClientJpa.findById(client1.getNumero());
		//logger.debug("client1" + client1);
		
		//assertEquals(-30.2, op1CompteARelu.getMontant(),0.00001);
		
		Client cliente1Relu = daoClientJpa.findClientWithCompteById(client1.getNumero());
		
		logger.debug("client1:" +cliente1Relu);
		logger.debug("  " +cliente1Relu.getComptes());

	}
}
