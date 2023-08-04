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
import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.service.ServiceCompte;
@RestController
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
public class CompteResrCtrl {
	
	//NB: cette version 1 n'utilise pas encore les DTOs 
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	private DtoConverter dtoConverter = new DtoConverter();
	
	//exemple de fin d'URL: ./api-bank/compte/1
	@GetMapping("/{numeroCompte}" )
	public ResponseEntity<?> getCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
	    Compte compte = serviceCompte.rechercherCompteParNumero(numeroCompte);
	
	    if(compte != null) 
	    	return new ResponseEntity<CompteDto>(dtoConverter.compteToCompteDto(compte), HttpStatus.OK);
	    	 else 
	    		 return new ResponseEntity<String>("\"err\" : \"compte not found\"}" , HttpStatus.NOT_FOUND);//40
	    
	    
	}

	
	//exemple de fin URL : ./api-bank/compte
	//ou encore:  ./api-bank/compte?soldeMini=0
	@GetMapping("" )
	public List<CompteDto> getComptes(@RequestParam(value="soldeMini",required=false) Double soldeMini){
		
		
		if(soldeMini==null)
			 return  dtoConverter.compteToCompteDto(serviceCompte.rechercherAll());
			 else{
				 	return dtoConverter.compteToCompteDto(serviceCompte.rechercherBySoldeMini(soldeMini));
			 }
	}
		
	//ex de fin URL: ./api-bank/compte
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	// {"numero" : null, "label": "compteQUiVaBien", "solde": 50.0}
	// ou bien  {"label": "compteQUiVaBien", "solde": 50.0}
	@PostMapping("" )
	public CompteDto postCompte(@RequestBody CompteDto nouveauCompte) {
		Compte compteEnregistreEnBase = serviceCompte.sauvegarderCompte(dtoConverter.compteDtoToCompte(nouveauCompte));
		return dtoConverter.compteToCompteDto(compteEnregistreEnBase);  // on retourne le compte avec la clé primaire auto-incrémentée
	}

	
	//ex de fin URL: ./api-bank/compte
		// appelé en mode PUT avec dans la partie invisible "body" de la requête
		// {"numero" : not null, "label": "compteQUiVaBien", "solde": 50.0}
	@PutMapping("" )
	public ResponseEntity<?> putCompteToUpdate(@RequestBody CompteDto compteDto, 
		      @PathVariable(value="numeroCompte",required = false ) Long numeroCompte) { 
		
		
		    Long numCompteToUpdate = numeroCompte!=null ? numeroCompte :compteDto.getNumero();
		    
		    //Compte compteQuiDevraitExister = serviceCompte.rechercherCompteParNumero(numCompteToUpdate);
		    if(!serviceCompte.verifierExistanceCompte(numCompteToUpdate))
		    	return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}" ,
 			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
		    
		    if(compteDto.getNumero() == null)
		    	compteDto.setNumero(numCompteToUpdate);
		    
		    serviceCompte.sauvegarderCompte(dtoConverter.compteDtoToCompte(compteDto));
		    return new ResponseEntity<CompteDto>(compteDto , HttpStatus.OK);
		    
			
			
	}
	
	
	//exemple de fin d'URL: ./api-bank/compte/1
		@DeleteMapping("/{numeroCompte}" )
		public ResponseEntity<?> deleteCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
		   // Compte compteAsupprimer = daoCompteJpa.findById(numeroCompte).orElse(null);
		    if(!serviceCompte.verifierExistanceCompte((numeroCompte)))
		    	   		 return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}" ,
		 			           HttpStatus.NOT_FOUND);//40
		    serviceCompte.supprimerCompte(numeroCompte);
		    return new ResponseEntity<>("{ \"done\" : \"compte deleted\"}" ,
		    	   HttpStatus.OK);
		    // ou bien
		   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    		    
		}
}
