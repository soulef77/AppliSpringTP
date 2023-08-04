package fr.inetum.tp.services;

import java.sql.Connection;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;


public abstract class AdresseService implements IAdresseService {

	
	
	public AdresseService( ) {}
	public AdresseService(Connection connection) {}
	
	public  Set<Adresse> AllAdresses(){
		return null;}
	public  Adresse readAdresses(int i){
		return null;}
	public  Adresse AddAdresses(Adresse ad) {
		return ad;}
	
	
}
