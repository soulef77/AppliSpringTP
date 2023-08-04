package fr.inetum.formation;

public class User {
String email;
String mdp;


public User(String email, String mdp) {
	super();
	this.email = email;
	this.mdp = mdp;
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
}
