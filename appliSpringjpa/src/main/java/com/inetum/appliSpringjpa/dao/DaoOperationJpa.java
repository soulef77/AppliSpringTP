package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.inetum.appliSpringjpa.entity.Operation;

@Repository
@Transactional
public class DaoOperationJpa implements DaoOperation {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Operation findById(Long idOp) {
		return entityManager.find(Operation.class, idOp);
	}

	@Override
	public List<Operation> findAll() {
		return entityManager.createQuery("SELECT o FROM Operation o", Operation.class).getResultList();
	}

	@Override
	public Operation insert(Operation op) {
		entityManager.persist(op);
		return op;
	}

	@Override
	public void update(Operation op) {
		entityManager.merge(op);

	}

	@Override
	public void deleteById(Long idOp) {
		Operation opeAsupprime = entityManager.find(Operation.class,idOp);
		entityManager.remove(opeAsupprime);
	}

}
