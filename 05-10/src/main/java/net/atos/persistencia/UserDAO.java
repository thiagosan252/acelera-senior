package net.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import net.atos.model.User;

public class UserDAO {

	public static long cadastrarUsuario(User user) {

		Long userId = null;
		String query = "insert into usuario (name, email, contact) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getContact());

			pstm.execute();
			
			try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					userId = generatedKeys.getLong(1);
				}
			} catch (Exception e) {
				System.out.println("Erro ao obter o id do usuario: " + e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar usuario: " + e.getMessage());
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

		return userId;
	}
	
	public static User buscarUsuario(String email) {

		String query = "select name, email, contact from usuario where email = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		
		User user = new User();
		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, email);

			resultSet = pstm.executeQuery();
			while(resultSet.next()) {
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setContact(resultSet.getString("contact"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
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

		return user;
	}

}
