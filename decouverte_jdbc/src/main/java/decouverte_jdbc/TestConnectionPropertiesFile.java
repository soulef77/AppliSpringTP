package decouverte_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnectionPropertiesFile {


	static String driver;
	static String url;
	static String username;
	static String password;
	
	public static void main(String[] args) {
		ResourceBundle props = ResourceBundle.getBundle("dbParams");
		
		driver= props.getString("mysql.driver");
		url = props.getString("mysql.url");
		username = props.getString("mysql.username");
		password = props.getString("mysql.password");
		System.out.println(driver);
		
		try {
			Class.forName(driver);
			System.out.println("DRIVER OK");
			try(Connection connection = DriverManager.getConnection(url, username, password)) {
				System.out.println(" connection ok");
			} catch (SQLException e) {
				System.out.println(" connection nok");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");
		}
		

	}

}
