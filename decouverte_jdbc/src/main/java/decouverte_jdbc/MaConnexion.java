package decouverte_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import decouverte_jdbc.jdbc.utils.SimpleDataSource;


/*
 * Permet de récupérer l'instance unique de la classe
 * @return l'unique instance de la classe
 * @throws ClassNotFoundException si le driver de bdd est ins
 * @throws SQLEXception si un pb de connexion
 */
public class MaConnexion {
	
	private static MaConnexion instance;
	private Connection connection;
	
	private MaConnexion() throws ClassNotFoundException, SQLException{
		SimpleDataSource.init("dbParams");
		connection = SimpleDataSource.getConnection();
	}
	
	public static synchronized MaConnexion getInstance() throws SQLException, ClassNotFoundException{
		if(instance == null) {
			instance = new MaConnexion();
		}
		return instance;
	   }

	/*
	 * permet de recupérer une connexion java.sql
	 */
	public Connection getConnection( ) {
		return connection;
	}
		
}
