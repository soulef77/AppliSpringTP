package com.inetum.appliSpringWeb.dao;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Compte;



public interface DaoCompte extends DaoGeneric<Compte, Long>{
	List<Compte> findBySoldeMini(double d);
	List<Compte> findBySoldeMax(double d);

	
}
