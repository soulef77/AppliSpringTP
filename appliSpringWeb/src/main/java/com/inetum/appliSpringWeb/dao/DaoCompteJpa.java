package com.inetum.appliSpringWeb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.entity.Compte;




@Repository
@Transactional
public class DaoCompteJpa extends DaoGenericJpa<Compte, Long> implements DaoCompte{


	@PersistenceContext
	private EntityManager entityManager;

	public DaoCompteJpa() {
		super(Compte.class);
	}
	
	@Override
	public EntityManager getEntityManager() {

		return entityManager;
	}
	

	@Override
	public List<Compte> findBySoldeMini(double d) {
		return 
				 entityManager.createQuery("select c from Compte as c where c.solde >= ?1", Compte.class)
				 .setParameter(1, d)
				 .getResultList();
	}

	@Override
	public List<Compte> findBySoldeMax(double d) {
		return 
				 entityManager.createQuery("select c from Compte as c where c.solde <= ?1", Compte.class)
				 .setParameter(1, d)
				 .getResultList();
	}

	


}
