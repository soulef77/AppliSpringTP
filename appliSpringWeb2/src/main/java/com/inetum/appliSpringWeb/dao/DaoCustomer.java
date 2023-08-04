package com.inetum.appliSpringWeb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliSpringWeb.entity.Customer;

public interface DaoCustomer  extends JpaRepository<Customer,Long>{ 

	//Customer findByCustomerId(long idCustomer);
	Optional<Customer> findByWithCompteByCustomerId(long idCustomer);
	
	List<Customer> findByLastnameAndFirstname(String lastname, String firstname);

	
}
