package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.dto.CustomerDto;
import com.inetum.appliSpringWeb.entity.Customer;

public interface ServiceCustomer extends GenericService<Customer,Long, CustomerDto> {

	/*Customer searchById(long idCustomer);*/
	Customer rechercherCustomerAvecComptesParNumero(long idCustomer);
	
	/*Customer saveOrUpdate(Customer customer);*/
	/*void deleteById(long numeroCustomer);
	boolean existById(long numeroCustomer);*/
	
	boolean checkCustomerPassWord(long customerId,String password);
	String resetCustomerPassWord(long customerId);
	List<Customer> rechercherSelonPrenomEtNom(String lastname, String firstname);
	
	
}
