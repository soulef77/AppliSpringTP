package com.inetum.appliSpring.tp;


import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy
//@Component //pour que cette classe soit prise en charge par Spring
//@Scope("singleton")
//@Component("prefixeurV1quejaime")
@Component
@Profile("V2")
public class PrefixeurV2 implements Prefixeur {

	private String prefixe= "##";
	
	@Override
	public String prefixer(String chaine) {
		return prefixe+chaine;
	}

	@Override
	public String prefixerMaj(String chaine) {
		return prefixe +chaine.toUpperCase();
	}

}
