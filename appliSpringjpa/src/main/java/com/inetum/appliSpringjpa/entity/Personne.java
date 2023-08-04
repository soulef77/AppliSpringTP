package com.inetum.appliSpringjpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typePersonne", 
 discriminatorType = DiscriminatorType.STRING)
public class Personne {
	
	public enum EtatPersonne{ENDORMIE,REVEILLEE};
	
	@Enumerated(EnumType.STRING)
	private EtatPersonne etat = EtatPersonne.REVEILLEE;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	public EtatPersonne getEtat() {
		return etat;
	}

	public void setEtat(EtatPersonne etat) {
		this.etat = etat;
	}

	@Column(name="prenom", length=64)
	private String prenom;
	
	private String nom;	
	
	public Personne() {
		super();
	}

	public Personne(Long numero, String prenom, String nom) {
		super();
		this.numero = numero;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
