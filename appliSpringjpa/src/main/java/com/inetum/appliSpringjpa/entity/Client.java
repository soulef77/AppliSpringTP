package com.inetum.appliSpringjpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;




@Entity
@NamedQuery(name="Client.findByPrenom", query="select cl from Client as cl where cl.prenom= ?1")
@NamedQuery(name="Client.findClientWithCompteById", query="select cl from Client cl LEFT JOIN FETCH cl.comptes o where cl.numero= ?1")
@DiscriminatorValue(value = "Client")
public class Client extends Personne{
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	 @JoinColumn(name = "id_adr" , unique=true) 
	private Adresse adressePrincipale;
	
	
	//@OneToMany(fetch=FetchType.LAZY,mappedBy="client")

	public Adresse getAdressePrincipale() {
		return adressePrincipale;
	}

	public void setAdressePrincipale(Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}


	@ManyToMany(fetch=FetchType.LAZY, mappedBy="clients")
	private List<Compte> comptes;
		

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client() {
		super();
	}
		
	public Client(Long numero, String prenom, String nom) {
		super(numero, prenom,nom);
	}


	@Override
	public String toString() {
		return "Client" + super.toString() + adressePrincipale;
	}
		
	
	
}
