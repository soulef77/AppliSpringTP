package com.inetum.appliSpring.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class EncadreurImpl implements Encadreur {

	public EncadreurImpl() {
		System.out.println("dans constructeur V1, prefixeur ="+ this.prefixeur);
	}
	
	@PostConstruct
	public void initialisation() {
		System.out.println("dans init préfixe par postConstructeur=" + this.prefixeur);
	}
	
	
	@Autowired
	private Prefixeur prefixeur;
	
	@Autowired
	private Suffixeur suffixeur;
	
	@Override
	public String encadrer(String chaine) {
		return suffixeur.suffixer(prefixeur.prefixer(chaine));
	}

	@Override
	public String encadrerMaj(String chaine) {
		return  suffixeur.suffixerMaj(prefixeur.prefixerMaj(chaine));
	}

}
