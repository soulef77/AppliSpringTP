package com.inetum.appliSpring.tp2;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PasDrole")
public class GenerateurBlaguePasDrole implements GenerateurBlague {

	private String blagues(){
		String[] blaguesDroles= {"blague1: rentre qui veut, sors qui peut","blague2: rira bien qui rira le dernier","blague3: j'ai rien trouvé"};
		
		return blaguesDroles[new Random().nextInt(3)];
		
	}
	
	@Override
	public String nouvelleBlague() {
		return blagues();
	}
	
	
}
