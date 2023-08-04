package com.inetum.appliSpringWeb.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * DTO= Data Transfert Object
 * Objet de données transféré à travers le réseau
 *
 */
@Getter @Setter @ToString @NoArgsConstructor
public class Devise {
	
	@Schema(description = "code le devise", example = "EUR")
	private String code; //ex:USD
	
	private String nom; // ex: dollar
	private Double change; // change pour 1 euro
	

	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}
	
	
}
