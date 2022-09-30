package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.atos.impacta.model.Funcionario;

public class FuncionarioDAO {

	public static boolean salvarFuncionario(Funcionario funcionario) {

		boolean bRet = false;
		String query = "insert into funcionario (nome, cpf, endereco_id) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());

			if (funcionario.getEndereco() != null) {
				Long enderecoId = null;

				enderecoId = EnderecoDAO.salvarEndereco(funcionario.getEndereco());
				if (enderecoId != null) {
					pstm.setInt(3, enderecoId.intValue());
				}

			} else {
				pstm.setString(3, null);
			}

			pstm.execute();

			if (funcionario.getSalarioLiquido() != null) {
				if (!SalarioDAO.salvarSalario(funcionario.getCpf(), funcionario.getSalarioLiquido()))
					return false;
			}
			bRet = true;
		} catch (Exception e) {
			bRet = false;
			System.out.println("Erro ao salvar funcionario");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				bRet = false;
				System.out.println("Erro ao fechar conexão");
			}

		}

		return bRet;
	}

	public static boolean verificaSeExiste(String cpf) {

		String query = "select func.cpf, func.nome from funcionario func where cpf = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		boolean bRet = false;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);
			pstm.setString(1, cpf);
			resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				bRet = true;
				break;
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionario: " + e.getMessage());
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

	public static boolean deletarFuncionario(String cpf) {

		boolean bRet = false;
		String query = "delete from funcionario where cpf = ?";
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
			System.out.println("Erro ao deletar funcionario: " + e.getMessage());
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

	public static int atualizarFuncionario(Funcionario funcionario) {
		int iRet = 0;

		String query = "update funcionario set nome = ? where cpf = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());

			iRet = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar funcionario: " + e.getMessage());
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
