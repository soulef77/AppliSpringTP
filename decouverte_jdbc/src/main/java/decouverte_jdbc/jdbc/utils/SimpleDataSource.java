package decouverte_jdbc.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Permet de charger les paramètre de connexion à la BDD depuis le fichier de pro
 * @author Administrateur
 * @param nomFichier le nom du fichier de properties contenant les params de connexion
 * @throws ClassNotFoundException si le driver de ls bdd est introvabl
 *
 */
public class SimpleDataSource {

	static String driver;
	static String url;
	static String username;
	static String password;
	
	static public void init(String nomFichier) throws ClassNotFoundException {
		
		ResourceBundle props = ResourceBundle.getBundle(nomFichier);
	
		driver= props.getString("mysql.driver");
		Class.forName(driver);
		url = props.getString("mysql.url");
		username = props.getString("mysql.username");
		password = props.getString("mysql.password");
		
		
	}
	
	public static void init(String nomFichier, String driverKey, String urlKey, String usernameKey, String passwordKey) {
		
	}
	
	/*
	 * Permet d'établir une connexion à la bdd à parir des paramètres de connexion 
	 * @return la connexion java.sql à la bdd
	 * @throws SQLExceptin si un problème survient lors de l'établissement à la connexion
	 */
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
}
