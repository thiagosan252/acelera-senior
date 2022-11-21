package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioCoordenador;
import br.atos.impacta.view.CadastroCoordenador;
import br.impacta.persistencia.CoordenadorDAO;

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

		String id = jTextField.getText();
		if (repositorio.verificarDuplicidade(id)) {
			JOptionPane.showMessageDialog(null, "Coordenador localizado com sucesso.");
			jFrameAtual.setVisible(false);
			CadastroCoordenador cadastroCoordenador = new CadastroCoordenador(jFrameAtual, repositorio, CoordenadorDAO.buscaCoordenador(id).get(0));
			cadastroCoordenador.showMenu();
			
		} else {
			JOptionPane.showMessageDialog(null, "Coordenador não cadastrado.");
		}

	}

}
