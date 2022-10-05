package net.atos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	private static String DB_HOST = "bwck2bsizstaojf0jc30-mysql.services.clever-cloud.com";
	private static String DB_NAME = "bwck2bsizstaojf0jc30";
	private static String DB_PORT = "3306";
	private static String USERNAME = "uwlpgaftuvjuqdvp";
	private static String PASSWORD = "1fgJVzG7jk8CKAAcmaH9";
	private static String URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

	public static Connection conectarDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return connection;
	}

}
