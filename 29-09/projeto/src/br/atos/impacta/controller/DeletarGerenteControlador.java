package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioGerente;

public class DeletarGerenteControlador implements ActionListener {

	JTextField jTextField;
	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	RepositorioGerente repositorio;

	public DeletarGerenteControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioGerente repositorio,
			JTextField idjTextField) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.jTextField = idjTextField;
		this.repositorio = repositorio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (repositorio.deletarGerente(jTextField.getText())) {
			JOptionPane.showMessageDialog(null, "Gerente deletado com sucesso.");
			jFrameAtual.setVisible(false);
			jFrameMenuInicial.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "CPF não encontrado.");
		}

	}

}
