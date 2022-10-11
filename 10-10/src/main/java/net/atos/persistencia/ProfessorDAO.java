package net.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.atos.model.Endereco;
import net.atos.model.Professor;

public class ProfessorDAO {

	public static boolean salvar(Professor professor, int pessoaId) {
		boolean bRet = false;
		
		return bRet;
	}
	
	public static List<Professor> buscar(String cpf) {

		List<Professor> professoresList = new ArrayList<Professor>();
		String query = "select p.nome, p.cpf, prof.disciplina, prof.salario, en.rua, en.cidade, en.numero "
				+ " from professor prof " + " left join pessoa p on prof.pessoa_id = p.id"
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
				Professor professor = new Professor();
				professor.setNome(resultSet.getString("nome"));
				professor.setCpf(resultSet.getString("cpf"));
				professor.setDisciplina(resultSet.getString("disciplina"));
				professor.setSalario(resultSet.getDouble("salario"));
				Endereco endereco = new Endereco();
				endereco.setRua(resultSet.getString("rua"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setNumero(String.valueOf(resultSet.getInt("numero")));
				professor.setEndereco(endereco);
				professoresList.add(professor);

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
		return professoresList;
	}
	
	public static boolean editar() {
		boolean bRet = false;
		
		return bRet;
	}
	
}
