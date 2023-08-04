package com.inetum.appliSpringWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoCustomer;
import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.dto.CustomerDto;
import com.inetum.appliSpringWeb.entity.Customer;


@Service
@Transactional
public class ServiceCustomerImpl extends AbstractGenericService<Customer, Long, CustomerDto> implements ServiceCustomer {

	@Autowired
	private DaoCustomer daoCustomer;
	
	@Override
	public CrudRepository<Customer, Long> getDao() {
		return this.daoCustomer;
	}


	@Override
	public Class<CustomerDto> getDtoClass() {
		return CustomerDto.class;
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
	public List<Customer> rechercherSelonPrenomEtNom(String lastname,String firstname) {
		return  daoCustomer.findByLastnameAndFirstname(lastname,firstname);
	}

	@Override
	public Customer rechercherCustomerAvecComptesParNumero(long idCustomer) {
		
		return daoCustomer.findByWithCompteByCustomerId(idCustomer).orElse(null);
	}

	
}
