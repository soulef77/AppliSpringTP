package com.inetum.appliSpring.tp2;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Drole")
public class GenerateurBlagueDrole implements GenerateurBlague {

	private String blagues(){
		String[] blaguesDroles= {"blague1: le zebu n'a jmais soif","blague2: quel est l'animal le pls dangereux: la tortue","blague3: j'ai rien trouvé"};
		
		return blaguesDroles[new Random().nextInt(3)];
		
	}
	
	@Override
	public String nouvelleBlague() {
		return blagues();
	}
	
}
