package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioCoordenador;

public class DeletarCoordenadorControlador implements ActionListener {

	JTextField jTextField;
	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	RepositorioCoordenador repositorio;

	public DeletarCoordenadorControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial,
			RepositorioCoordenador repositorio, JTextField idjTextField) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.jTextField = idjTextField;
		this.repositorio = repositorio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (repositorio.deletarCoordenador(jTextField.getText())) {
			JOptionPane.showMessageDialog(null, "Coordenador deletado com sucesso.");
			jFrameAtual.setVisible(false);
			jFrameMenuInicial.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "CPF não encontrado.");
		}
	}

}
