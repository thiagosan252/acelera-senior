package br.impacta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Endereco;
import br.atos.impacta.model.Gerente;

public class GerenteDAO {

	public static boolean salvarGerente(Gerente gerente) {

		boolean bRet = false;
		String query = "insert into gerente (cpf_funcionario, regional, meta_regional) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, gerente.getCpf());
			pstm.setString(2, gerente.getRegional());
			pstm.setDouble(3, gerente.getMetaRegional());

			pstm.execute();
			bRet = true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar gerente: " + e.getMessage());
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

	public static List<Gerente> buscaGerente(String cpf) {

		List<Gerente> gerenteList = new ArrayList<Gerente>();
		String query = "select func.nome, func.cpf, func.endereco_id, s.salario_liquido, g.regional, g.meta_regional, e.rua, e.estado, e.numero "
				+ " from gerente g left join funcionario func on func.cpf = g.cpf_funcionario"
				+ " left join endereco e on e.id = func.endereco_id"
				+ " left join salario s on func.cpf = s.cpf_funcionario"
				+ (cpf != null ? " where func.cpf = ? " : "");
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

			while (resultSet.next()) {
				Gerente gerente = new Gerente();
				gerente.setNome(resultSet.getString("nome"));
				gerente.setCpf(resultSet.getString("cpf"));
				gerente.setSalarioLiquido(resultSet.getDouble("salario_liquido"));
				gerente.setRegional(resultSet.getString("regional"));
				gerente.setMetaRegional(resultSet.getDouble("meta_regional"));
				
				Endereco endereco = new Endereco();
				endereco.setRua(resultSet.getString("rua"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setCasa(String.valueOf(resultSet.getInt("numero")));
				endereco.setId(resultSet.getInt("endereco_id"));
				gerente.setEndereco(endereco);
				
				gerenteList.add(gerente);
				
				System.out.println(gerente.toString());

			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar gerente: " + e.getMessage());
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
		return gerenteList;
	}

	public static int atualizarGerente(Gerente gerente) {
		int iRet = 0;

		String query = "update gerente set regional = ?, meta_regional = ? where cpf_funcionario = ?";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, gerente.getRegional());
			pstm.setDouble(2, gerente.getMetaRegional());
			pstm.setString(3, gerente.getCpf());

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
