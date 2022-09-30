package br.atos.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Funcionario;
import br.atos.impacta.model.Gerente;
import br.atos.impacta.model.IGerente;
import br.impacta.persistencia.EnderecoDAO;
import br.impacta.persistencia.FuncionarioDAO;
import br.impacta.persistencia.GerenteDAO;
import br.impacta.persistencia.SalarioDAO;

public class RepositorioGerente implements IGerente {

	private List<Gerente> gerentes = new ArrayList<Gerente>();

	@Override
	public boolean salvarGerente(Gerente gerente) {
		boolean bRet = false;
		try {
			gerentes.add(gerente);
			Funcionario funcionario = new Funcionario(gerente.getNome(), gerente.getSalarioLiquido(), gerente.getCpf());
			funcionario.setEndereco(gerente.getEndereco());
			bRet = FuncionarioDAO.salvarFuncionario(funcionario);
			if (bRet)
				bRet = GerenteDAO.salvarGerente(gerente);
			System.out.println("Cadastrado = " + gerente.toString() + " | " + gerente.getEndereco().toString());
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar: " + e);
			return bRet;
		}
		return bRet;
	}

	@Override
	public List<Gerente> listarGerentes() {
		return GerenteDAO.buscaGerente(null);
	}

	@Override
	public boolean deletarGerente(String cpf) {
		return FuncionarioDAO.deletarFuncionario(cpf);
	}

	@Override
	public boolean alterarGerente(Gerente gerente, String cpf) {
		boolean bRet = false;
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(cpf);
			funcionario.setNome(gerente.getNome());
			
			FuncionarioDAO.atualizarFuncionario(funcionario);
			GerenteDAO.atualizarGerente(gerente);
			EnderecoDAO.atualizarEndereco(gerente.getEndereco());
			SalarioDAO.atualizarSalario(cpf, gerente.getSalarioLiquido());

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
