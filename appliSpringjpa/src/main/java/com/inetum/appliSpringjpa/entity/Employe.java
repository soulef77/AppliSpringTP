package com.inetum.appliSpringjpa.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Employe.findByPrenom", query="select e from Employe as e where e.prenom= ?1") 
@DiscriminatorValue(value = "Employe")
public class Employe extends Personne {

	private String email;
		
	@Override
	public String toString() {
		return "Employe" + super.toString();
	}
	public Employe() {
		super();
	}
	public Employe(Long numero, String prenom, String nom) {
		super(numero,prenom,nom);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
