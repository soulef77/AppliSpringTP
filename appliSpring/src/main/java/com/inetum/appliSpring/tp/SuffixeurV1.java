package com.inetum.appliSpring.tp;


import org.springframework.stereotype.Component;

//@Lazy
//@Component //pour que cette classe soit prise en charge par Spring
//@Scope("singleton")
//@Component("prefixeurV1quejaime")
@Component
public class SuffixeurV1 implements Suffixeur {

	private String suffixe= "**";
	
		@Override
	public String suffixer(String chaine) {
		return chaine+suffixe;
	}

	@Override
	public String suffixerMaj(String chaine) {
		
		return chaine.toUpperCase()+suffixe;
	}

}
