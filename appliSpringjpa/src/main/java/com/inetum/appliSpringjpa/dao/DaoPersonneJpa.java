package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringjpa.entity.Personne;


@Repository
@Transactional
public class DaoPersonneJpa extends DaoGenericJpa<Personne,Long> implements DaoPersonne {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public DaoPersonneJpa() {
		super(Personne.class);
	}

	
}
