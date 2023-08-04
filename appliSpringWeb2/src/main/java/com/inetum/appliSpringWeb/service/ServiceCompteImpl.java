package com.inetum.appliSpringWeb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoOperation;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@Component
@Service
@Transactional
public class ServiceCompteImpl implements ServiceCompte {

	Logger logger= LoggerFactory.getLogger(ServiceCompteImpl.class);
	
	@Autowired
	private DaoCompte daoCompte;
	
	@Autowired
	private DaoOperation daoOperation;
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRED)
	public void transferer(double montant, long numCptDeb, long numCptCred) throws BankException {
		
		try {
			/*
			Compte compteDeb = daoCompte.findById(numCptDeb).get();
			compteDeb.setSolde(compteDeb.getSolde() - montant);
			daoCompte.save(compteDeb);
			*/
			this.debiterCompte(numCptDeb, montant, "debit suite au virement vers le compte " +numCptDeb);
			
			/*Compte compteCred= daoCompte.findById(numCptCred).get();
			compteCred.setSolde(compteCred.getSolde() - montant);
			daoCompte.save(compteCred);*/
			
			this.crediterCompte(numCptCred, montant, "credit suite au virement depuis le compte " +numCptDeb);
		} catch (Exception e) {
		
			logger.error("echec virement " + e.getMessage());
			throw new BankException("echec virement",e);
//			e.printStackTrace();
		}

	}

	@Override
	public Compte rechercherCompteParNumero(long numeroCompte) {
		// TODO Auto-generated method stub
		return daoCompte.findById(numeroCompte).orElse(null);
	}

	@Override
	public List<Compte> rechercherCompteDuClient(long numeroCompte) {
		return daoCompte.findByCustomerId(numeroCompte);
	}

	@Override
	public Compte sauvegarderCompte(Compte compte) {
		return daoCompte.save(compte);
	}

	@Override
	public void supprimerCompte(long numeroCompte) {
		daoCompte.deleteById(numeroCompte);
	}

	@Override
	public boolean verifierExistanceCompte(long numeroCompte) {
		return daoCompte.existsById(numeroCompte);
	}

	@Override
	public void debiterCompte(long numeroCompte, double montant, String message) {
		
		Compte compteDeb = daoCompte.findById(numeroCompte).get();
		double nouveauSoldeTheoriqueApresDebit = compteDeb.getSolde() - montant;
		if(nouveauSoldeTheoriqueApresDebit >= Compte.getDecouvertAutorise()) {
			compteDeb.setSolde(nouveauSoldeTheoriqueApresDebit);
			daoCompte.save(compteDeb);
			
			Operation opDebit = daoOperation.save(
		    		new Operation(null, -montant , message , new Date() , compteDeb));
			
			
		}else {
		throw new BankException("solde insuffisant vis à vis du decouvert autorisé= "+ Compte.getDecouvertAutorise()+ "pour effectuer un debit");
		}
	}

	@Override
	public void crediterCompte(long numeroCompte, double montant, String message) {
		Compte compteCred= daoCompte.findById(numeroCompte).get();
		compteCred.setSolde(compteCred.getSolde() + montant);
		daoCompte.save(compteCred);
		
		Operation opCredit = daoOperation.save(
	    		new Operation(null,montant , message , new Date() , compteCred));
		
	}

	@Override
	public Compte rechercherCompteAvceOperationsParNumero(long numeroCompte) {
		return daoCompte.findByWithOperations(numeroCompte).orElse(null);
	}

	@Override
	public List<Operation> operationsDuCompteQueJaime(long numeroCompte) {
		Compte cpt=daoCompte.findByWithOperations(numeroCompte).get();
		return cpt.getOperations();
	}

	@Override
	public List<Compte> rechercherAll() {
		return daoCompte.findAll() ;
	}

	@Override
	public List<Compte> rechercherBySoldeMini(Double soldeMini) {
		
		return daoCompte.findBySoldeGreaterThanEqual(soldeMini);
	}

}
