package com.inetum.appliSpringjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.inetum.appliSpringjpa.dao.DaoCompteJpaSansSpring;
import com.inetum.appliSpringjpa.dao.DaoEmployeJpaSansSpring;
import com.inetum.appliSpringjpa.entity.Compte;
import com.inetum.appliSpringjpa.entity.Employe;

public class TestSansSpringApp {

	public static void testDaoCompte(DaoCompteJpaSansSpring daoCompteJpa) {
		Compte cpt1 = new Compte(null,"laposte", 5000.0);
		
		daoCompteJpa.insert(cpt1);
		
		daoCompteJpa.insert(new Compte(null,"sg", 1000.0));
		daoCompteJpa.insert(new Compte(null,"ca", 10000.0));
		daoCompteJpa.insert(new Compte(null,"sg", 8000.0));
		daoCompteJpa.insert(new Compte(null,"ca", 90000.0));
		
		List<Compte>compteAyanPourSoldeMini = daoCompteJpa.findBySoldeMini(300.0);
		System.err.println("numero de compte avec solde min"+ compteAyanPourSoldeMini);
		
		List<Compte>compteAyanPourSoldeMax = daoCompteJpa.findBySoldeMax(30000.0);
		System.err.println("numero de compte avec solde max"+ compteAyanPourSoldeMax);
		
		
	}

	public static void testDaoEmploye(DaoEmployeJpaSansSpring daoEmployeJpa) {
		Employe emp1 = new Employe(null, "prenom1", "Nom");
		
		daoEmployeJpa.insert(new Employe(null,"soussou","sky"));
		daoEmployeJpa.insert(new Employe(null,"soussou","sea"));
		
		daoEmployeJpa.insert(new Employe(null,"kiko","sky"));
		daoEmployeJpa.insert(new Employe(null,"kiko","sea"));
		
		List<Employe>employeAyantPrenomSoussou = daoEmployeJpa.findByPrenom("soussou");
		System.err.println("emplSoussou "+ employeAyantPrenomSoussou);
		
		
		Employe emp1Sauvegarde = daoEmployeJpa.insert(emp1);
		Long numEmp1 = emp1Sauvegarde.getNumero();
		System.err.println(" numéro auto incrémenté de emp1 "+ emp1Sauvegarde.getNumero());
		
		Employe emp1Relu = daoEmployeJpa.findById(numEmp1);
		System.err.println("emp1Relu "+ emp1Relu);
		
		emp1Relu.setNom("moi");
		emp1Relu.toString();
		
		daoEmployeJpa.update(emp1Relu);
		
		//daoEmployeJpa.deleteById(numEmp1);
		
		Employe emp1ReReluQuiExistePlus = daoEmployeJpa.findById(numEmp1);
		System.err.println(" emprerelu "+ emp1ReReluQuiExistePlus);
		
//		List<Employe> employes = daoEmployeJpa.findAll();
//		for (Employe emp : employes) {
//			//System.out.println(emp);
//		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appliSpringJpa");
		// NB: appliSpringJpa= name du persistent-unit configuré dans
		// META-INF/persistence.xml
		EntityManager entityManager = emf.createEntityManager();
		DaoEmployeJpaSansSpring daoEmployeJpa = new DaoEmployeJpaSansSpring();
		daoEmployeJpa.setEntityManager(entityManager);
		
		DaoCompteJpaSansSpring daoCompteJpa = new DaoCompteJpaSansSpring();
		daoCompteJpa.setEntityManager(entityManager);
		
		testDaoEmploye(daoEmployeJpa);
		testDaoCompte(daoCompteJpa);
		
		entityManager.close();
		emf.close();

	}

}
