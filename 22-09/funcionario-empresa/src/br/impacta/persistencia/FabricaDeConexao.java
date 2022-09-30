package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	private static String DB_HOST = "localhost";
	private static String DB_NAME = "funcionario_db";
	private static String DB_PORT = "3306";
	private static String USERNAME = "root";
	private static String PASSWORD = "senha$00";
	private static String URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

	public static Connection conectarDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return connection;
	}

}
