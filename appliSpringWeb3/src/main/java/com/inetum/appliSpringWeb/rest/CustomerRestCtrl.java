package com.inetum.appliSpringWeb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.appliSpringWeb.converter.DtoConverter;
import com.inetum.appliSpringWeb.converter.GenericConverter;
import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.dto.CustomerDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;
import com.inetum.appliSpringWeb.service.ServiceCustomer;

@RestController
@RequestMapping(value="/api-client/customer" , headers="Accept=application/json")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
public class CustomerRestCtrl {

	@Autowired
	private ServiceCustomer serviceCustomer;
	
	private DtoConverter dtoConverter = new DtoConverter();
	
	@GetMapping("/{numeroCustomer}" )
	public ResponseEntity<?> getCustomerByNumero(@PathVariable("numeroCustomer") Long numeroCustomer) {
	    CustomerDto customerDto = serviceCustomer.searchDtoById(numeroCustomer);
	
	    if(customerDto != null) 
	    	return new ResponseEntity<CustomerDto>(GenericConverter.map(customerDto, CustomerDto.class), HttpStatus.OK);
	    	 else 
	    		 return new ResponseEntity<String>("\"err\" : \"customer not found\"}" , HttpStatus.NOT_FOUND);//40
	    
	    
	}
	
	
	//exemple de fin URL : ./api-bank/compte
		//ou encore:  ./api-bank/compte?soldeMini=0
		@GetMapping("" )
		public List<CustomerDto> getCustomers(){
			
			return serviceCustomer.searchAllDTO();
		}
			
	
		@PostMapping("" )
		public CustomerDto postCustomer(@RequestBody CustomerDto nouveauCustomerDto) {
			
			Customer compteEnregistreEnBase = serviceCustomer.saveOrUpdate(GenericConverter.map(nouveauCustomerDto, Customer.class));
			return  GenericConverter.map(compteEnregistreEnBase,CustomerDto.class);
			
		}
		
		
		
		@PutMapping("" )
		public ResponseEntity<?> putCompteToUpdate(@RequestBody CustomerDto customerDto, 
			      @PathVariable(value="numeroCustomer",required = false ) Long numeroCustomer) { 
			
			
			    Long numCustomerToUpdate = numeroCustomer!=null ? numeroCustomer :customerDto.getId();
			    
			    //Compte compteQuiDevraitExister = serviceCompte.rechercherCompteParNumero(numCompteToUpdate);
			    if(!serviceCustomer.existById(numCustomerToUpdate))
			    	return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}" ,
	 			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
			    
			    if(customerDto.getId() == null)
			    	customerDto.setId(numCustomerToUpdate);
			    
			    serviceCustomer.saveOrUpdate(GenericConverter.map(customerDto, Customer.class));
			    return new ResponseEntity<CustomerDto>(customerDto , HttpStatus.OK);
			    			
		}
		
		
		
		@DeleteMapping("/{numeroCustomer}" )
		public ResponseEntity<?> deleteCustomerByNumero(@PathVariable("numeroCustomer") Long numeroCustomer) {
		   // Compte compteAsupprimer = daoCompteJpa.findById(numeroCompte).orElse(null);
		    if(!serviceCustomer.existById((numeroCustomer)))
		    	   		 return new ResponseEntity<String>("{ \"err\" : \"customer not found\"}" ,
		 			           HttpStatus.NOT_FOUND);//40
		    serviceCustomer.deleteById(numeroCustomer);
		    return new ResponseEntity<>("{ \"done\" : \"customer deleted\"}" ,
		    	   HttpStatus.OK);
		    // ou bien
		   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    		    
		}
				
	
}
