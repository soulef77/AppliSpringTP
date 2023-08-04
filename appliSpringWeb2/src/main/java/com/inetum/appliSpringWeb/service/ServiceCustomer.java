package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Customer;

public interface ServiceCustomer {

	Customer rechercherCustomerParId(long idCustomer);
	Customer rechercherCustomerAvecComptesParNumero(long idCustomer);
	
	Customer sauvegarderCustomer(Customer customer);
	void supprimerCUstomer(long numeroCustomer);
	boolean verifierExistanceCustomer(long numeroCustomer);
	
	boolean checkCustomerPassWord(long customerId,String password);
	String resetCustomerPassWord(long customerId);
	List<Customer> rechercherSelonPrenomEtNom(String lastname, String firstname);
	
	
}
