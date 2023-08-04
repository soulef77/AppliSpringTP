package com.inetum.appliSpringWeb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliSpringWeb.entity.Compte;



public interface DaoCompte extends JpaRepository<Compte, Long>{
	List<Compte> findBySoldeGreaterThanEqual(double d);
	List<Compte> findBySoldeLessThanEqual(double d);
	
	
	//codé via @NameQuery(name="Compte.findBySoldeMini")
	List<Compte> findBySoldeMini(double soldeMini);
	
	Optional<Compte> findByWithOperations(Long numero);
	
	List<Compte> findByCustomerId(Long numero);
	
/**
 * findALl()
 * findById()
 * save()
 * deleteById()
 * héritées de JpaRepository/CrUDRepository	
 */
}
