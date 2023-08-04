package com.inetum.mbean;



import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class CalculTVA {

	private Double prixHT;
	
	private Double prixTTC;
	
	private Double tauxTVA;
	
	private Double prixTVA;
	
	public Double getPrixTVA() {
		return prixTVA;
	}

	public void setPrixTVA(Double prixTVA) {
		this.prixTVA = prixTVA;
	}

	public String calculerTVA() {
		String suite= null;
			
		prixTTC = (prixHT*tauxTVA/100) + prixHT;
		prixTVA = prixHT*tauxTVA/100;
	
		return suite;
		
	}
	
	public Double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Double prixHT) {
		this.prixHT = prixHT;
	}

	public Double getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(Double prixTTC) {
		this.prixTTC = prixTTC;
	}

	public Double getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(Double tauxTVA) {
		this.tauxTVA = tauxTVA;
	}
	
	
}
