package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringjpa.entity.Client;


@Repository
@Transactional
public class DaoClientJpa implements DaoClient {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Client findById(Long numero) {
		return entityManager.find(Client.class, numero);
	}

	@Override
	public List<Client> findAll() {
		return entityManager.createQuery("SELECT cl FROM Client cl", Client.class).getResultList();
	}


	@Override
	public Client insert(Client cl) {
		entityManager.persist(cl);
		return cl;
	}

	@Override
	public void update(Client cl) {
		entityManager.merge(cl);
	}

	@Override
	public void deleteById(Long numero) {
		Client clientsupprime = entityManager.find(Client.class,numero);
		entityManager.remove(clientsupprime);
	}
	
	@Override
	public Client findClientWithCompteById(Long numero) {
				
		return entityManager.createNamedQuery("Client.findClientWithCompteById",Client.class)
		 .setParameter(1, numero)
		 .getSingleResult();
	}


}
