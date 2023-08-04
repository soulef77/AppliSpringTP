package decouverte_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMaConnexion {

	public static void main(String[] args) {
	
			try(Connection connection = MaConnexion.getInstance().getConnection()){
				System.out.println("Test ma connexion ok");
			
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
	}
}
