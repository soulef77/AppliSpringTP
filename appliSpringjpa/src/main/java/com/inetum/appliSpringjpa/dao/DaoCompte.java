package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.inetum.appliSpringjpa.entity.Compte;



public interface DaoCompte extends DaoGeneric<Compte, Long>{

	
	Compte findCompteWithOperationById(Long numero);
	
	List<Compte> findByLabel(String label);
	List<Compte> findBySoldeMini(double d);
	List<Compte> findBySoldeMax(double d);
	void setEntityManager(EntityManager entityManager);
	void trouverEtDebiter(Long numCompte, double montantDebit);
	
}
