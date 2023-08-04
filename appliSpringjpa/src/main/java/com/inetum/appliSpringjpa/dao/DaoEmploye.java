package com.inetum.appliSpringjpa.dao;

import java.util.List;

import com.inetum.appliSpringjpa.entity.Employe;

/**
 * 
 * DAO = Data Access Object
 * avec methode CRUD
 *
 */

public interface DaoEmploye {
	Employe findById(Long numero);
	List<Employe> findAll();
	List<Employe> findByPrenom(String prenom);
	Employe insert(Employe emp);
	void update(Employe emp);
	void deleteById(Long numero);
	
}
