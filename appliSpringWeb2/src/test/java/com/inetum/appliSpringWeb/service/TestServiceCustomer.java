package com.inetum.appliSpringWeb.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;



@SpringBootTest
public class TestServiceCustomer {

Logger logger= LoggerFactory.getLogger(TestServiceCompte.class);
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	@Autowired
	private ServiceCustomer serviceCustomer;
	
	@Test
	public void testFindCustomerById() {
		Customer customerA= serviceCustomer.sauvegarderCustomer(new Customer(null, "dada", "loulou","pass"));
		Compte compte1= new Compte(null,"la poste",100.00);
		Compte compte2= new Compte(null,"BNP",200.00);
		
		compte1.setCustomer(customerA);
		compte2.setCustomer(customerA);
		
		Compte compte1deA = serviceCompte.sauvegarderCompte(compte1);
		Compte compte2deA = serviceCompte.sauvegarderCompte(compte2);
		
		Customer customer1Relu = serviceCustomer.rechercherCustomerAvecComptesParNumero(customerA.getId());
		assertTrue(customer1Relu.getComptes().size()==2);
		
	}
	
	
	@Test
	public void testSurPassword() {
		Customer c1 = serviceCustomer.sauvegarderCustomer(
				new Customer(null,"prenom1" , "nom1" , "pwd1"));
		
		boolean pwdNotOK = serviceCustomer.checkCustomerPassWord(c1.getId(), "wrongPwd");
		assertFalse(pwdNotOK);
		boolean pwdOK = serviceCustomer.checkCustomerPassWord(c1.getId(), "pwd1");
		assertTrue(pwdOK);
		
		String resetPwd = serviceCustomer.resetCustomerPassWord(c1.getId()); 
		logger.trace("reset password =" + resetPwd);
		pwdOK = serviceCustomer.checkCustomerPassWord(c1.getId(), resetPwd);
		assertTrue(pwdOK);
		
	}
	
	@Test
	public void testFindSpecifique() {
		Customer c1 = serviceCustomer.sauvegarderCustomer(
				new Customer(null,"jean" , "Bon" , "pwd1"));
		Customer c1Bis = serviceCustomer.sauvegarderCustomer(
				new Customer(null,"jean" , "Bon" , "pwd1Bis"));
		
		List<Customer> customers = serviceCustomer.rechercherSelonPrenomEtNom("jean" , "Bon");
		logger.trace("pour jean Bon, customers=" + customers);
		assertTrue(customers.size()==2);
		
	}

}
