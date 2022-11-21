package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SalarioDAO {

	public static boolean salvarSalario(String cpf, Double salario) {

		boolean bRet = false;
		String query = "insert into salario (cpf_funcionario, salario_liquido) values (?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, cpf);
			pstm.setDouble(2, salario);

			pstm.execute();
			bRet = true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar salario");
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

	public static int atualizarSalario(String cpf, Double salario) {
		int iRet = 0;

		String query = "update salario set salario_liquido = ? where cpf_funcionario = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setDouble(1, salario);
			pstm.setString(2, cpf);

			iRet = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar salario: " + e.getMessage());
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
