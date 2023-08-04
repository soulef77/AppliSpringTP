package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringjpa.entity.Compte;




@Repository
@Transactional
public class DaoCompteJpa implements DaoCompte{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Compte findById(Long numero) {
		return entityManager.find(Compte.class, numero);
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
		
			// en entrée , emp est un nouvel objet employé avec .empId à null (encore
			// inconnu)
			// déclenche automatiquement INSERT INTO Employe(firstname, ....)
			// VALUES(emp.getFirstname() , ....)
			entityManager.persist(cpt);// .empId n'est normalement plus null si auto-incr
			return cpt; // on retourne l'objet modifié (avec .empId non null)

	}

	@Override
	public void update(Compte cpt) {
		entityManager.merge(cpt);
		
	}

	@Override
	public void deleteById(Long num) {
		Compte compteAsupprimer = entityManager.find(Compte.class, num);
		entityManager.remove(compteAsupprimer);
		
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
		//solution1
		/*Compte compte= entityManager.find(Compte.class, numero);
		for(Operation op : compte.getOperations()) {
			//boucle à vide sue les operations en mode lazy, pour que ça déclenche des petits 
			// select qui remoentent tout de suite les valeurs en mémoire
			//avec la fin de la transaction et avant entityManager.close de Sprinf ou autre
		}
		return compte;*/
		
		
		return entityManager.createNamedQuery("Compte.findCompteWithOperationById",Compte.class)
		 .setParameter(1, numero)
		 .getSingleResult();
	}
	
	@Override
	public void trouverEtDebiter(Long numCompte, double montantDebit) {
		Compte comptePersistant = entityManager.find(Compte.class, numCompte);
		comptePersistant.setSolde(comptePersistant.getSolde() - 20.0);
		
		
	}

}
