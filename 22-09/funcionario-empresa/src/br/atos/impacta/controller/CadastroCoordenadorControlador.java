package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.repository.RepositorioCoordenador;

public class CadastroCoordenadorControlador implements ActionListener {

	RepositorioCoordenador repositorio;

	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	JTextField nomeJTextField;
	JTextField cpfJTextField;
	JTextField lojaJTextField;
	JTextField metaDaLojaJTextField;
	JTextField horasTrabJTextField;

	public CadastroCoordenadorControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial,
			RepositorioCoordenador repositorio, JTextField nomeJTextField, JTextField cpfJTextField,
			JTextField lojaJTextField, JTextField metaDaLojaJTextField, JTextField horasTrabJTextField) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
		this.nomeJTextField = nomeJTextField;
		this.cpfJTextField = cpfJTextField;
		this.lojaJTextField = lojaJTextField;
		this.metaDaLojaJTextField = metaDaLojaJTextField;
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
		Coordenador coordenador = new Coordenador();
		coordenador.setNome(nomeJTextField.getText());
		coordenador.setCpf(cpfJTextField.getText());
		coordenador.setLoja(lojaJTextField.getText());
		try {
			coordenador.setMetaDaLoja(Double.valueOf(metaDaLojaJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor de meta da loja inválida.");
		}

		try {
			coordenador.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Horas trabalhadas inválidas.");
		}

		if (repositorio.salvarCoordenador(coordenador)) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar.");
			return false;
		}
	}

}
