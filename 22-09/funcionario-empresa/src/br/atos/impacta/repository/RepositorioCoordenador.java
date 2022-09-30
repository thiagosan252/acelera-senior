package br.atos.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.model.Funcionario;
import br.atos.impacta.model.ICoordenador;
import br.impacta.persistencia.CoordenadorDAO;
import br.impacta.persistencia.EnderecoDAO;
import br.impacta.persistencia.FuncionarioDAO;
import br.impacta.persistencia.SalarioDAO;

public class RepositorioCoordenador implements ICoordenador {

	private List<Coordenador> coordenadores = new ArrayList<Coordenador>();

	@Override
	public boolean salvarCoordenador(Coordenador coordenador) {
		boolean bRet = false;
		try {
			coordenadores.add(coordenador);
			Funcionario funcionario = new Funcionario(coordenador.getNome(), coordenador.getSalarioLiquido(),
					coordenador.getCpf());
			funcionario.setEndereco(coordenador.getEndereco());
			bRet = FuncionarioDAO.salvarFuncionario(funcionario);
			if (bRet)
				bRet = CoordenadorDAO.salvarCoordenador(coordenador);
			System.out.println("Cadastrado = " + coordenador.toString() + " | " + coordenador.getEndereco().toString());
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar: " + e);
			bRet = false;
		}
		return bRet;
	}

	@Override
	public List<Coordenador> listarCoordenadores() {
		return CoordenadorDAO.buscaCoordenador(null);
	}

	@Override
	public boolean deletarCoordenador(String cpf) {
		return FuncionarioDAO.deletarFuncionario(cpf);
	}

	@Override
	public boolean alterarCoordenador(Coordenador coordenador, String cpf) {
		boolean bRet = false;
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(cpf);
			funcionario.setNome(coordenador.getNome());
			FuncionarioDAO.atualizarFuncionario(funcionario);
			CoordenadorDAO.atualizarCoordenador(coordenador);
			EnderecoDAO.atualizarEndereco(coordenador.getEndereco());
			SalarioDAO.atualizarSalario(cpf, coordenador.getSalarioLiquido());

			bRet = true;
		} catch (Exception e) {
			System.out.println("Erro ao atualizar: " + e);
		}
		return bRet;
	}

	@Override
	public boolean verificarDuplicidade(String cpf) {
		return FuncionarioDAO.verificaSeExiste(cpf);
	}

}
