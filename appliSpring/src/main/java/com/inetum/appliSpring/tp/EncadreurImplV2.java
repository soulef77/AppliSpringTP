package com.inetum.appliSpring.tp;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncadreurImplV2 implements Encadreur {
	
	private Prefixeur prefixeur;

	private Suffixeur suffixeur;
	
	public EncadreurImplV2() {
		System.out.println("dans constructeur, prefixeur ="+ this.prefixeur);
	}
	
//	@Autowired
	public EncadreurImplV2(Prefixeur prefixeur, Suffixeur suffixeur) {
		System.out.println("dans constructeur V2, prefixeur ="+ this.prefixeur);
		this.prefixeur=prefixeur;
		this.suffixeur=suffixeur;
	}
	
	
	@PostConstruct
	public void initialisation() {
		System.out.println("dans init préfixe par postConstructeur=" + this.prefixeur);
	}
	
	
	@Override
	public String encadrer(String chaine) {
		return suffixeur.suffixer(prefixeur.prefixer(chaine));
	}

	@Override
	public String encadrerMaj(String chaine) {
		return  suffixeur.suffixerMaj(prefixeur.prefixerMaj(chaine));
	}

}
