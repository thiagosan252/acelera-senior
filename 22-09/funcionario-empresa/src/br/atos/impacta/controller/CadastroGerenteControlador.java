package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	public CadastroGerenteControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioGerente repositorio,
			JTextField nomeJTextField, JTextField cpfJTextField, JTextField regionalJTextField,
			JTextField metaRegionalJTextField, JTextField horasTrabJTextField) {
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

		if (repositorio.verificarDuplicidade(cpfJTextField.getText())) {
			JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
		} else {
			if (this.save()) {
				jFrameAtual.setVisible(false);
				jFrameMenuInicial.setVisible(true);
			}

		}

	}

	private boolean save() {
		Gerente gerente = new Gerente();
		gerente.setNome(nomeJTextField.getText());
		gerente.setCpf(cpfJTextField.getText());
		gerente.setRegional(regionalJTextField.getText());
		try {
			gerente.setMetaRegional(Double.valueOf(metaRegionalJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor de meta regional inválido.");
		}
		try {
			gerente.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Horas trabalhadas inválidas.");

		}

		if (repositorio.salvarGerente(gerente)) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar.");
			return false;
		}
	}

}
