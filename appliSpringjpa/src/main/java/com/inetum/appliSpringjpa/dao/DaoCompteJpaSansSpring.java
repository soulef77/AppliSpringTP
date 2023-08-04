package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.inetum.appliSpringjpa.entity.Compte;

public class DaoCompteJpaSansSpring implements DaoCompte{

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private EntityManager entityManager;

	@Override
	public Compte findById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte insert(Compte cpt) {
		try {
			entityManager.getTransaction().begin();
			// en entrée , emp est un nouvel objet employé avec .empId à null (encore
			// inconnu)
			// déclenche automatiquement INSERT INTO Employe(firstname, ....)
			// VALUES(emp.getFirstname() , ....)
			entityManager.persist(cpt);// .empId n'est normalement plus null si auto-incr
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec insertNew(compte)");
		}
		return cpt; // on retourne l'objet modifié (avec .empId non null)

	}

	@Override
	public void update(Compte cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
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

	@Override
	public Compte findCompteWithOperationById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trouverEtDebiter(Long numCompte, double montantDebit) {
		// TODO Auto-generated method stub
		
	}

}
