package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.model.Endereco;
import br.atos.impacta.model.Gerente;
import br.atos.impacta.repository.RepositorioGerente;

public class CadastroGerenteControlador implements ActionListener {

	RepositorioGerente repositorio;

	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;
	boolean edit = false;

	JTextField nomeJTextField;
	JTextField cpfJTextField;
	JTextField regionalJTextField;
	JTextField metaRegionalJTextField;
	JTextField horasTrabJTextField;

	JTextField estadoJTextField;
	JTextField ruaJTextField;
	JTextField casaJTextField;
	int enderecoId;

	public CadastroGerenteControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioGerente repositorio,
			JTextField nomeJTextField, JTextField cpfJTextField, JTextField regionalJTextField,
			JTextField metaRegionalJTextField, JTextField horasTrabJTextField, JTextField estadoJTextField,
			JTextField ruaJTextField, JTextField casaJTextField, int enderecoId, Boolean edit) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
		this.nomeJTextField = nomeJTextField;
		this.cpfJTextField = cpfJTextField;
		this.regionalJTextField = regionalJTextField;
		this.metaRegionalJTextField = metaRegionalJTextField;
		this.horasTrabJTextField = horasTrabJTextField;
		this.estadoJTextField = estadoJTextField;
		this.ruaJTextField = ruaJTextField;
		this.casaJTextField = casaJTextField;
		this.enderecoId = enderecoId;
		this.edit = edit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!this.edit) {
			if (repositorio.verificarDuplicidade(cpfJTextField.getText())) {
				JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
			} else {
				if (this.save()) {
					jFrameAtual.setVisible(false);
					jFrameMenuInicial.setVisible(true);
				}

			}
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
			return false;
		}
		try {
			gerente.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Horas trabalhadas inválidas.");
			return false;
		}

		Endereco endereco = new Endereco();
		endereco.setEstado(estadoJTextField.getText());
		endereco.setRua(ruaJTextField.getText());
		endereco.setCasa(casaJTextField.getText());
		endereco.setId(enderecoId);
		gerente.setEndereco(endereco);
		if (!this.edit) {
			if (repositorio.salvarGerente(gerente)) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar.");
				return false;
			}
		} else {
			if (repositorio.alterarGerente(gerente, cpfJTextField.getText())) {
				JOptionPane.showMessageDialog(null, "Gerente atualizado com sucesso.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao atualizar.");
				return true;
			}
		}
	}

}
