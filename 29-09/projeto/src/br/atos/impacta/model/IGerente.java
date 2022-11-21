package br.atos.impacta.model;

import java.util.List;

public interface IGerente {

	public boolean salvarGerente(Gerente gerente);

	public List<Gerente> listarGerentes();

	public boolean deletarGerente(String cpf);

	public boolean alterarGerente(Gerente gerente, String cpf);

	public boolean verificarDuplicidade(String cpf);
}
