package com.inetum.appliSpringWeb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.inetum.appliSpringWeb.entity.Operation;

@Repository
@Transactional
public class DaoOperationJpa extends DaoGenericJpa<Operation,Long> implements DaoOperation {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public DaoOperationJpa() {
		super(Operation.class);
	}

}
