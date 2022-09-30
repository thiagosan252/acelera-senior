package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.model.Endereco;

public class CoordenadorDAO {

	public static boolean salvarCoordenador(Coordenador coordenador) {

		boolean bRet = false;
		String query = "insert into coordenador (cpf_funcionario, loja, meta_loja) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, coordenador.getCpf());
			pstm.setString(2, coordenador.getLoja());
			pstm.setDouble(3, coordenador.getMetaDaLoja());

			pstm.execute();
			bRet = true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar coordenador: " + e.getMessage());
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

	public static List<Coordenador> buscaCoordenador(String cpf) {

		List<Coordenador> coordenadorList = new ArrayList<Coordenador>();
		String query = "select func.nome, func.cpf, s.salario_liquido, c.loja, c.meta_loja, e.rua, e.estado, e.numero "
				+ " from coordenador c " + " left join funcionario func on func.cpf = c.cpf_funcionario"
				+ " left join endereco e on e.id = func.endereco_id"
				+ " left join salario s on func.cpf = s.cpf_funcionario" + (cpf != null ? " where func.cpf = ? " : "");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			if (cpf != null) {
				pstm.setString(1, cpf);
			}

			resultSet = pstm.executeQuery();

			Coordenador coordenador = new Coordenador();
			while (resultSet.next()) {
				coordenador.setNome(resultSet.getString("nome"));
				coordenador.setCpf(resultSet.getString("cpf"));
				coordenador.setSalarioLiquido(resultSet.getDouble("salario_liquido"));
				coordenador.setLoja(resultSet.getString("loja"));
				coordenador.setMetaDaLoja(resultSet.getDouble("meta_loja"));
				Endereco endereco = new Endereco();
				endereco.setRua(resultSet.getString("rua"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setCasa(String.valueOf(resultSet.getInt("numero")));
				coordenador.setEndereco(endereco);
				coordenadorList.add(coordenador);

			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar coordenador: " + e.getMessage());
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
		return coordenadorList;
	}

	public static int atualizarCoordenador(Coordenador coordenador) {
		int iRet = 0;

		String query = "update coordenador set loja = ?, meta_loja = ? where cpf_funcionario = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, coordenador.getLoja());
			pstm.setDouble(2, coordenador.getMetaDaLoja());
			pstm.setString(3, coordenador.getCpf());

			iRet = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar gerente: " + e.getMessage());
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
