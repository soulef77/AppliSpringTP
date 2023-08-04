package com.inetum.data;

public class Produit {
	private String ref;
	private String label;
	private Double prix;
	private String categorie;
	
	
	
	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", label=" + label + ", categorie=" + categorie + ", prix=" + prix + "]";
	}
	
	public Produit(String ref, String label, Double prix, String categorie) {
		super();
		this.ref = ref;
		this.label = label;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
}
