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
import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dto.ApiError;
import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.service.ServiceCompte;
@RestController
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
public class CompteResrCtrl {
	
	//NB: cette version 2  DTOs 
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	private DtoConverter dtoConverter = new DtoConverter();
	
	/*
	//exemple de fin d'URL: ./api-bank/compte/1
	@GetMapping("/{numeroCompte}" )
	public ResponseEntity<?> getCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
	    CompteDto compteDto = serviceCompte.searchDTOById(numeroCompte);
	
	    if(compteDto != null) 
	    	return new ResponseEntity<CompteDto>(compteDto, HttpStatus.OK);
	    	 else 
	    		 return new ResponseEntity<ApiError>(
  			           new ApiError(HttpStatus.NOT_FOUND ,"compte not found") ,
  			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
	    
	    
	}
*/
	
	//exemple de fin d'URL: ./api-bank/compte/1
		@GetMapping("/{numeroCompte}" )
		public CompteDto getCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
			    return serviceCompte.searchDtoById(numeroCompte);
			    //en cas de numero de compte pas trouvé
			    //l'exception "NotFoundException" remontée par l'appel à .searchDtoById(...)
			    //est automatiquement gérée par RestResponseEntityExceptionHandler
			    //et  celui ci construit et retourne automatiquement
			    //un ResponseEntity<ApiError> avec le bon status http et le bon message
		}
	
	
	//exemple de fin URL : ./api-bank/compte
	//ou encore:  ./api-bank/compte?soldeMini=0
	@GetMapping("" )
	public List<CompteDto> getComptes(@RequestParam(value="soldeMini",required=false) Double soldeMini){
		
		
		if(soldeMini==null)
			 return  serviceCompte.searchAllDTO();
			 else{
				 	return dtoConverter.compteToCompteDto(serviceCompte.rechercherBySoldeMini(soldeMini));
			 }
	}
		
	//ex de fin URL: ./api-bank/compte
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	// {"numero" : null, "label": "compteQUiVaBien", "solde": 50.0}
	// ou bien  {"label": "compteQUiVaBien", "solde": 50.0}
	/*@PostMapping("" )
	public CompteDto postCompte(@RequestBody CompteDto nouveauCompte) {
		Compte compteEnregistreEnBase = serviceCompte.saveOrUpdate(dtoConverter.compteDtoToCompte(nouveauCompte));
		return dtoConverter.compteToCompteDto(compteEnregistreEnBase);  // on retourne le compte avec la clé primaire auto-incrémentée
	}*/
	
	
	
	//exemple de fin d'URL: ./api-bank/compte
		//appelé en mode POST avec dans la partie invisible "body" de la requête:
		// { "numero" : null , "label" : "compteQuiVaBien" , "solde" : 50.0 }
		// ou bien { "label" : "compteQuiVaBien" , "solde" : 50.0 }
		@PostMapping("" )
		public CompteDto postCompte(@RequestBody CompteDto nouveauCompte) {
			Compte compteEnregistreEnBase = serviceCompte.saveOrUpdate(
					              dtoConverter.compteDtoToCompte(nouveauCompte) );
			//on retourne le compte avec clef primaire auto_incrémentée
			return dtoConverter.compteToCompteDto(compteEnregistreEnBase); 
		}
	

	
	//ex de fin URL: ./api-bank/compte
		// appelé en mode PUT avec dans la partie invisible "body" de la requête
		// {"numero" : not null, "label": "compteQUiVaBien", "solde": 50.0}
	@PutMapping("" )
	public ResponseEntity<?> putCompteToUpdate(@RequestBody CompteDto compteDto, 
		      @PathVariable(value="numeroCompte",required = false ) Long numeroCompte) { 
		
		
		    Long numCompteToUpdate = numeroCompte!=null ? numeroCompte :compteDto.getNumero();
		    
		    //Compte compteQuiDevraitExister = serviceCompte.rechercherCompteParNumero(numCompteToUpdate);
		    if(!serviceCompte.existById(numCompteToUpdate))
		    	return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}" ,
 			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
		    
		    if(compteDto.getNumero() == null)
		    	compteDto.setNumero(numCompteToUpdate);
		    
		    serviceCompte.saveOrUpdate(dtoConverter.compteDtoToCompte(compteDto));
		    return new ResponseEntity<CompteDto>(compteDto , HttpStatus.OK);
		    
			
			
	}
	
	/*
	//exemple de fin d'URL: ./api-bank/compte/1
		@DeleteMapping("/{numeroCompte}" )
		public ResponseEntity<?> deleteCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
		   // Compte compteAsupprimer = daoCompteJpa.findById(numeroCompte).orElse(null);
		    if(!serviceCompte.existById((numeroCompte)))
		    	   		 return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}" ,
		 			           HttpStatus.NOT_FOUND);//40
		    serviceCompte.deleteById(numeroCompte);
		    return new ResponseEntity<>("{ \"done\" : \"compte deleted\"}" ,
		    	   HttpStatus.OK);
		    // ou bien
		   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    		    
		}*/
	
	
	//exemple de fin d'URL: ./api-bank/compte/1
			//à déclencher en mode DELETE
			@DeleteMapping("/{numeroCompte}" )
			public ResponseEntity<?> deleteCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
				    serviceCompte.deleteById(numeroCompte);//retournant NotFoundException
				    return new ResponseEntity<String>("{ \"done\" : \"compte deleted\"}" ,
				    		                          HttpStatus.OK); 
				}
}
