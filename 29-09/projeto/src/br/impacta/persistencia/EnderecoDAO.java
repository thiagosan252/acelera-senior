package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.atos.impacta.model.Endereco;

public class EnderecoDAO {

	public static long salvarEndereco(Endereco endereco) {

		Long ret = null;
		String query = "insert into endereco (rua, estado, numero) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getEstado());
			pstm.setInt(3, Integer.valueOf(endereco.getCasa()));

			pstm.execute();

			try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					ret = generatedKeys.getLong(1);
				}
				System.out.println("Endereco criado com sucesso. Id = " + ret);
			} catch (Exception e) {
				System.out.println("Erro ao obter o id do endereço: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar endereco: " + e.getMessage());
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

		return ret;
	}

	public static int atualizarEndereco(Endereco endereco) {
		int iRet = 0;

		String query = "update endereco set rua = ?, estado = ?, numero = ? where id = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getEstado());
			pstm.setInt(3, Integer.valueOf(endereco.getCasa()));
			
			pstm.setInt(4, endereco.getId());

			iRet = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar endereco: " + e.getMessage());
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

		return iRet;
	}
	

}
