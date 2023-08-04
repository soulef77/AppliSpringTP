package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;

public interface IStagiaireService {

	
	public abstract Set<Stagiaire> AllStagiaires() throws ClassNotFoundException, SQLException;
	public  Set<Stagiaire> AllStagiaire(Adresse ad);
	public abstract  void updateStagiaire(Stagiaire st, Adresse ad);
	public abstract  void addStagiaire(Stagiaire st, Adresse ad);
	public abstract  Stagiaire getStagiaire(String a ,String b);
	public abstract  Stagiaire getStagiaire(int i);
	public abstract void deleteStagiaire(Integer id) throws ClassNotFoundException, SQLException;
	
}
