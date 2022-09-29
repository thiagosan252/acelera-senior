package br.atos.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.model.ICoordenador;

public class RepositorioCoordenador implements ICoordenador {

	private List<Coordenador> coordenadores = new ArrayList<Coordenador>();

	@Override
	public boolean salvarCoordenador(Coordenador coordenador) {

		try {
			coordenadores.add(coordenador);
			System.out.println("Cadastrado = " + coordenador.toString() + " | " + coordenador.getEndereco().toString());
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar: " + e);
			return false;
		}
		return true;
	}

	@Override
	public List<Coordenador> listarCoordenadores() {
		return this.coordenadores;
	}

	@Override
	public boolean deletarCoordenador(String cpf) {
		return coordenadores.removeIf(c -> c.getCpf().equals(cpf));
	}

	@Override
	public boolean alterarCoordenador(Coordenador coordenador, String cpf) {
		try {
			coordenadores.stream().filter(c -> c.getCpf().equals(cpf)).peek(d -> {
				d.setNome(coordenador.getNome());
				d.setLoja(coordenador.getLoja());
				d.setMetaDaLoja(coordenador.getMetaDaLoja());
				d.setSalarioLiquido(coordenador.getSalarioLiquido());
			}).findFirst();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar: " + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean verificarDuplicidade(String cpf) {
		Coordenador coordenador = coordenadores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
		if (coordenador == null)
			return false;
		else
			return true;
	}

}
