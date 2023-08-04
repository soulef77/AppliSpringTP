package com.inetum.appliSpringjpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CompteEpargne")
public class CompteEpargne extends Compte{

	public CompteEpargne(Long numero, String label, Double solde, double tauxInteret) {
		super(numero, label, solde);
		this.tauxInteret = tauxInteret;
	}

	private double tauxInteret;

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public CompteEpargne(double tauxInteret) {
		super();
		this.tauxInteret = tauxInteret;
	}
	
}
