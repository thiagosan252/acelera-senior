package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.impacta.model.Gerente;
import br.atos.impacta.repository.RepositorioGerente;

public class CadastroGerenteControlador implements ActionListener {

	RepositorioGerente repositorio;

	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	JTextField nomeJTextField;
	JTextField cpfJTextField;
	JTextField regionalJTextField;
	JTextField metaRegionalJTextField;
	JTextField horasTrabJTextField;

	public CadastroGerenteControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioGerente repositorio, JTextField nomeJTextField,
			JTextField cpfJTextField, JTextField regionalJTextField, JTextField metaRegionalJTextField,
			JTextField horasTrabJTextField) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
		this.nomeJTextField = nomeJTextField;
		this.cpfJTextField = cpfJTextField;
		this.regionalJTextField = regionalJTextField;
		this.metaRegionalJTextField = metaRegionalJTextField;
		this.horasTrabJTextField = horasTrabJTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.save();
		jFrameAtual.setVisible(false);
		jFrameMenuInicial.setVisible(true);
	}

	private void save() {
		Gerente gerente = new Gerente();
		gerente.setNome(nomeJTextField.getText());
		gerente.setCpf(cpfJTextField.getText());
		gerente.setRegional(regionalJTextField.getText());
		gerente.setMetaRegional(Double.valueOf(metaRegionalJTextField.getText()));
		gerente.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));

		if (repositorio.salvarGerente(gerente)) {
			System.out.println("Cadastrado com sucesso.");
		} else {
			System.out.println("Falha ao cadastrar.");
		}
	}

}
