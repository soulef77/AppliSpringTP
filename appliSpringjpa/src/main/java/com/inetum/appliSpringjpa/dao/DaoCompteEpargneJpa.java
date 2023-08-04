package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringjpa.entity.CompteEpargne;

@Repository
@Transactional
public class DaoCompteEpargneJpa implements DaoCompteEpargne {


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CompteEpargne findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteEpargne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteEpargne insert(CompteEpargne e) {
		entityManager.persist(e);
		return e;
	}

	@Override
	public void update(CompteEpargne e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long num) {
		// TODO Auto-generated method stub
		
	}

}
