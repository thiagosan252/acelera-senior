package br.atos.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Gerente;
import br.atos.impacta.model.IGerente;

public class RepositorioGerente implements IGerente {

	private List<Gerente> gerentes = new ArrayList<Gerente>();
	
	@Override
	public boolean salvarGerente(Gerente gerente) {
		try {
			gerentes.add(gerente);
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar: " + e);
			return false;
		}
		return true;
	}

	@Override
	public List<Gerente> listarGerentes() {
		return this.gerentes;
	}

	@Override
	public boolean deletarGerente(String cpf) {
		return gerentes.removeIf(g -> g.getCpf().equals(cpf));
	}

	@Override
	public boolean alterarGerente(Gerente gerente, String cpf) {
		try {
			gerentes.stream().filter(c -> c.getCpf().equals(cpf)).peek(d -> {
				d.setNome(gerente.getNome());
				d.setRegional(gerente.getRegional());
				d.setMetaRegional(gerente.getMetaRegional());
				d.setSalarioLiquido(gerente.getSalarioLiquido());
			}).findFirst();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar: " + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean verificarDuplicidade(String cpf) {

		Gerente gerente = gerentes.stream().filter(g -> g.getCpf().equals(cpf)).findFirst().orElse(null);
		if (gerente == null)
			return false;
		else
			return true;
	}

}
