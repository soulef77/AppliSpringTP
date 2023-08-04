package decouverte_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import decouverte_jdbc.jdbc.utils.SimpleDataSource;

public class TestSimpleDataSource {

	public static void main(String[] args) {
		try {
			SimpleDataSource.init("dbParams");
			System.out.println("DRIVER OK");
			
			try(Connection connection = SimpleDataSource.getConnection()) {
				System.out.println("connexion ok");
			} catch (SQLException e) {
				System.out.println("connexion nok");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");		}
	}

}
