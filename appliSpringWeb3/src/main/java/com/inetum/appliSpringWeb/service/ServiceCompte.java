package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;
import com.inetum.appliSpringWeb.exception.NotFoundException;

public interface ServiceCompte extends GenericService<Compte, Long, CompteDto>{
	
	void debiterCompte(long numeroCompte, double montant,String message);
	void crediterCompte(long numeroCompte, double montant,String message);
	void transferer(double montant, long numCptDeb, long numCptCred)  throws BankException;
	
	/*Compte searchById(long numeroCompte);*/
	Compte rechercherCompteAvceOperationsParNumero(long numeroCompte);
	List<Operation> operationsDuCompteQueJaime(long numeroCompte);
	List<Compte> rechercherCompteDuClient(long numeroCompte);
	
	/*Compte saveOrUpdate(Compte compte);*/
	/*void deleteById(Long numeroCompte);
	boolean existById(Long numeroCompte);*/
	
	List<Compte> searchAll();
	List<Compte> rechercherBySoldeMini(Double soldeMini);
	
	
	
	
}
