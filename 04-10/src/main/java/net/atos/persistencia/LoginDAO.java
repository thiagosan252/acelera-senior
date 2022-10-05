package net.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	public static boolean executaLogin(String username, String password) {
		
		boolean bRet = false;
		String query = "select * from login where username = ? and password = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		
		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);
			
			pstm.setString(1, username);
			pstm.setString(2, password);
			resultSet = pstm.executeQuery();
			
			bRet = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar login: " + e.getMessage());
		}
		return bRet;
	}
	
}
