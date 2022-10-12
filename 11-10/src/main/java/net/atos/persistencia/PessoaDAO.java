package net.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import net.atos.model.Pessoa;

public class PessoaDAO {

	public static long cadastrar(Pessoa pessoa) {

		Long userId = null;
		String query = "insert into pessoa (nome, cpf, endereco_id) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getCpf());
			pstm.setInt(3, pessoa.getEndereco().getId());

			pstm.execute();

			try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					userId = generatedKeys.getLong(1);
				}
			} catch (Exception e) {
				System.out.println("Erro ao obter o id da pessoa: " + e.getMessage());
			}

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
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
	

	public static boolean deletar(String cpf) {

		boolean bRet = false;
		String query = "delete from pessoa where cpf = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, cpf);

			int count = pstm.executeUpdate();
			if (count > 0)
				bRet = true;
			else
				bRet = false;

		} catch (Exception e) {
			System.out.println("Erro ao deletar pessoa: " + e.getMessage());
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
