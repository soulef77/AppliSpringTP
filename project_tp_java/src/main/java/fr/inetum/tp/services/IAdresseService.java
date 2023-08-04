package fr.inetum.tp.services;

import java.util.Set;

import fr.inetum.tp.entites.Adresse;


public interface IAdresseService {

	public abstract Set<Adresse> AllAdresses();
	public abstract Adresse readAdresses(int i);
	public abstract Adresse AddAdresses(Adresse ad);
	
}
