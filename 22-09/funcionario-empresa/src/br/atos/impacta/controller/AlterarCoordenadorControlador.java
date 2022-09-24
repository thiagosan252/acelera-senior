package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioCoordenador;

public class AlterarCoordenadorControlador implements ActionListener {

	JTextField jTextField;
	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	RepositorioCoordenador repositorio;

	public AlterarCoordenadorControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial,
			RepositorioCoordenador repositorio, JTextField idjTextField) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.jTextField = idjTextField;
		this.repositorio = repositorio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (repositorio.verificarDuplicidade(jTextField.getText())) {
			JOptionPane.showMessageDialog(null, "Coordenador localizado com sucesso.");
//			jFrameAtual.setVisible(false);
//			jFrameMenuInicial.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Coordenador não cadastrado.");
		}

	}

}
