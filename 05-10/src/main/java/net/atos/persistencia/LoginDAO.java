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

	public static boolean cadastrarLogin(Long userId, String username, String password) {

		boolean bRet = false;
		String query = "insert into login (userId, username, password) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setLong(1, userId);
			pstm.setString(2, username);
			pstm.setString(3, password);

			pstm.execute();
			bRet = true;
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar login do usuario: " + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				System.out.println("Erro ao fechar conexão");
			}

		}

		return bRet;
	}

}
