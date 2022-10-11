package net.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.atos.model.Endereco;
import net.atos.model.Estudante;

public class EstudanteDAO {

	public static boolean salvar(Estudante estudante, int pessoaId) {
		boolean bRet = false;

		String query = "insert into estudante (turma, media, pessoa_id) values (?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;

		try {
			connection = FabricaDeConexao.conectarDB();
			pstm = connection.prepareStatement(query);

			pstm.setString(1, estudante.getTurma());
			pstm.setDouble(2, estudante.getMedia());
			pstm.setInt(3, pessoaId);

			pstm.execute();

			bRet = true;

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar estudante: " + e.getMessage());
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
	
	public static List<Estudante> buscar(String cpf) {

		List<Estudante> estudantesList = new ArrayList<Estudante>();
		String query = "select p.nome, p.cpf, es.turma, es.media, en.rua, en.cidade, en.numero "
				+ " from estudante es " + " left join pessoa p on es.pessoa_id = p.id"
				+ " left join endereco en on en.id = p.endereco_id"
				+ (cpf != null ? " where p.cpf = ? " : "");
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
				Estudante estudante = new Estudante();
				estudante.setNome(resultSet.getString("nome"));
				estudante.setCpf(resultSet.getString("cpf"));
				estudante.setTurma(resultSet.getString("turma"));
				estudante.setMedia(resultSet.getDouble("media"));
				Endereco endereco = new Endereco();
				endereco.setRua(resultSet.getString("rua"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setNumero(String.valueOf(resultSet.getInt("numero")));
				estudante.setEndereco(endereco);
				estudantesList.add(estudante);

			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar estudante: " + e.getMessage());
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
		return estudantesList;
	}

	public static boolean editar() {
		boolean bRet = false;

		return bRet;
	}
	
}
