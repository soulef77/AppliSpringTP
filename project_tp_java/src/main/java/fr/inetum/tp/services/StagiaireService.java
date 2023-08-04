package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;


import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.utils.MaConnexion;

public class StagiaireService implements IStagiaireService {

	
	public StagiaireService() {}
	public StagiaireService(Connection connection) {}
	public StagiaireService(Connection connection, IAdresseService iad) {}
	
	public  Set<Stagiaire> AllStagiaires() throws ClassNotFoundException, SQLException{
		
		
		
		
		Set<Stagiaire> stagiaires = new HashSet<>();
		String requete = "SELECT * FROM stagiaire";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Date ddn = rs.getDate("ddn");
			String role=  rs.getString("role");
			Integer adresseId = rs.getInt("adresseId");
			Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,ddn,adresseId,role,id);
			stagiaires.add(stagiaire);
		}

		return stagiaires;
	}
	
	
	
	
	public  Set<Stagiaire> AllStagiaire(Adresse ad){
		return null;}
	public  void updateStagiaire(Stagiaire st, Adresse ad){}
	public  void addStagiaire(Stagiaire st, Adresse ad){}
	public  Stagiaire getStagiaire(String a ,String b) {
		return null;}
	public  Stagiaire getStagiaire(int i) {
		return null;}
	
	
	@Override
	public void deleteStagiaire(Integer id) throws ClassNotFoundException, SQLException {
		
		String requete= "DELETE FROM stagiaire WHERE id = ?";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setInt(1,id);
		stmt.executeUpdate();
	}
}
