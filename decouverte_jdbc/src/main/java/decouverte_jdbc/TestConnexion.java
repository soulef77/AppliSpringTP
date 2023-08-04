package decouverte_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {

	public static void main(String[] args) {
		Connection connection= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DRIVER OK");
			
			final String URL ="jdbc:mysql://localhost:3306/inetum_bd";
			final String USER = "root";
			final String PASSWORD = "";
			
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connection OK");
			
			
			
			} catch (SQLException e) {
					System.out.println("connection NOK");
													
			} catch (ClassNotFoundException e) {
					System.out.println("DRIVER NOK");
		}finally {
			if(connection != null)
			try {
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
