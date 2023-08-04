package com.inetum.appliSpringjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.inetum.appliSpringjpa.entity.Employe;

public class DaoEmployeJpaSansSpring implements DaoEmploye {

	private EntityManager entityManager;

	@Override
	public Employe findById(Long numero) {
		return entityManager.find(Employe.class, numero);
	}

//	@Override
//	public List<Employe> findAll() {
//		return entityManager.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
//	}
//	
	@Override
	public List<Employe> findByPrenom(String prenom) {
	
			return entityManager
					.createNamedQuery("Employe.findByPrenom", Employe.class)
					.setParameter(1, prenom)
					.getResultList();
			
	}
	/*		 
	@Override
	public List<Employe> findByPrenom(String prenom){
		return 
				 entityManager.createQuery("select e from Employe as e where e.prenom=:prenomCherche", Employe.class)
				 .setParameter("prenomCherche", prenom)
				 .getResultList();
	}*/
	
	@Override
	public Employe insert(Employe emp) {
		try {
			entityManager.getTransaction().begin();
			// en entrée , emp est un nouvel objet employé avec .empId à null (encore
			// inconnu)
			// déclenche automatiquement INSERT INTO Employe(firstname, ....)
			// VALUES(emp.getFirstname() , ....)
			entityManager.persist(emp);// .empId n'est normalement plus null si auto-incr
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec insertNew(employe)");
		}
		return emp; // on retourne l'objet modifié (avec .empId non null)

	}

	@Override
	public void update(Employe emp) {
		try {
			entityManager.getTransaction().begin();
			// en entrée , emp est un nouvel objet employé avec .empId à null (encore
			// inconnu)
			// déclenche automatiquement update INTO Employe(firstname, ....)
			// VALUES(emp.getFirstname() , ....)
			entityManager.merge(emp);// .empId n'est normalement plus null si auto-incr
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echecupdate(employe)");
		}

	}

	@Override
	public void deleteById(Long numero) {
		try {
			entityManager.getTransaction().begin();
			Employe empAsupprimer = entityManager.find(Employe.class, numero);
			entityManager.remove(empAsupprimer);
			// déclenche automatiquement DELETE FROM Employe WHERE idEmp=code
			// à peaufiner via try/catc
			// en entrée , emp est un nouvel objet employé avec .empId à null (encore
			// inconnu)
			// déclenche automatiquement update INTO Employe(firstname, ....)
			// VALUES(emp.getFirstname() , ....)
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec deleteByID");
		}
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
