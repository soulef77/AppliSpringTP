package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;

public interface ServiceCompte {
	
	void debiterCompte(long numeroCompte, double montant,String message);
	void crediterCompte(long numeroCompte, double montant,String message);
	void transferer(double montant, long numCptDeb, long numCptCred)  throws BankException;
	
	Compte rechercherCompteParNumero(long numeroCompte);
	Compte rechercherCompteAvceOperationsParNumero(long numeroCompte);
	List<Operation> operationsDuCompteQueJaime(long numeroCompte);
	List<Compte> rechercherCompteDuClient(long numeroCompte);
	
	Compte sauvegarderCompte(Compte compte);
	void supprimerCompte(long numeroCompte);
	boolean verifierExistanceCompte(long numeroCompte);
	
	List<Compte> rechercherAll();
	List<Compte> rechercherBySoldeMini(Double soldeMini);
	
	
}
