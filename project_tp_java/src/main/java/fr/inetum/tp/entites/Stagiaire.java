package fr.inetum.tp.entites;

import java.sql.Date;

public class Stagiaire {
 private String prenom;
 private String email;
 private String mdp;
 private Integer adresseId;
 private Date ddn; 
 private String role;
 private Integer id;
 
 
 
 
 

public Stagiaire(String prenom, String email) {
	super();
	this.prenom = prenom;
	this.email = email;
}

public Stagiaire(String prenom, String email, String mdp,Date ddn, Integer adresseId,  String role, Integer id) {
	super();
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
	this.adresseId = adresseId;
	this.ddn = ddn;
	this.role = role;
	this.id = id;
}
@Override
public String toString() {
	return "Stagiaire [prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresseId=" + adresseId + ", ddn="
			+ ddn + ", id=" + id + "]";
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public Integer getAdresseId() {
	return adresseId;
}
public void setAdresseId(Integer adresseId) {
	this.adresseId = adresseId;
}
public Date getDdn() {
	return ddn;
}
public void setDdn(Date ddn) {
	this.ddn = ddn;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
 
 
 
 
}
