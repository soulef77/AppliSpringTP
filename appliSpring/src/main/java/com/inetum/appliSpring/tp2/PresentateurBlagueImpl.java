package com.inetum.appliSpring.tp2;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PresentateurBlagueImpl implements PresentateurBlague {

	//@Autowired @Qualifier("Drole")
	private GenerateurBlague generateurBlagueDrole;
	
	//@Autowired @Qualifier("PasDrole")
	private GenerateurBlague generateurBlaguePasDrole;
	
	//public PresentateurBlagueImpl() {}
	
	@Autowired
	public PresentateurBlagueImpl(@Qualifier("Drole") GenerateurBlague  generateurBlagueDrole, @Qualifier("PasDrole") GenerateurBlague  generateurBlaguePasDrole ) {
		this.generateurBlagueDrole= generateurBlagueDrole;
		this.generateurBlaguePasDrole=generateurBlaguePasDrole;
	}
	
		
	
//	@PostConstruct
	public void initialisation() {
		System.out.println("dans init préfixe par postConstructeur=" + this.generateurBlagueDrole+"  "+ this.generateurBlaguePasDrole);
	}
		
	
	@Override
	public void presenterBlague() {
	System.out.println("NOUVELLE BLAGUE " +	generateurBlagueDrole.nouvelleBlague()+"  "+ generateurBlaguePasDrole.nouvelleBlague());
	}
	
}
