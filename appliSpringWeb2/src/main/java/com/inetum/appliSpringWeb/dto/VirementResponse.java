package com.inetum.appliSpringWeb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class VirementResponse {
	private Long numCompteDebit;
	private Long numCompteCredit;
	private Double montant;
	private Boolean status;
	private String message;
}
