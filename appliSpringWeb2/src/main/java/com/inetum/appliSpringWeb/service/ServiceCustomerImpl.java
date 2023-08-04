package com.inetum.appliSpringWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.dao.DaoCustomer;
import com.inetum.appliSpringWeb.entity.Customer;


@Service
@Transactional
public class ServiceCustomerImpl implements ServiceCustomer {

	@Autowired
	private DaoCustomer daoCustomer;
	
	public ServiceCustomerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer sauvegarderCustomer(Customer customer) {
		return daoCustomer.save(customer);
	}

	@Override
	public void supprimerCUstomer(long numeroCustomer) {
		daoCustomer.deleteById(numeroCustomer);
		
	}

	@Override
	public boolean verifierExistanceCustomer(long numeroCustomer) {
		return daoCustomer.existsById(numeroCustomer);
	}

	@Override
	public boolean checkCustomerPassWord(long customerId, String password) {
		Customer customerAVerifier= daoCustomer.findById(customerId).orElse(null);
		if(customerAVerifier==null || password==null) return false;
		return password.equals(customerAVerifier.getPassword());
	}

	@Override
	public String resetCustomerPassWord(long customerId) {
		Customer customerPourReset= daoCustomer.findById(customerId).get();
		customerPourReset.setPassword("newpassword");
		return customerPourReset.getPassword();
	}

	

	@Override
	public Customer rechercherCustomerParId(long idCustomer) {
		Customer customer= daoCustomer.findById(idCustomer).get();
		return customer;
	}

	

	@Override
	public List<Customer> rechercherSelonPrenomEtNom(String lastname,String firstname) {
		return  daoCustomer.findByLastnameAndFirstname(lastname,firstname);
	}

	@Override
	public Customer rechercherCustomerAvecComptesParNumero(long idCustomer) {
		
		return daoCustomer.findByWithCompteByCustomerId(idCustomer).orElse(null);
	}

	

}
