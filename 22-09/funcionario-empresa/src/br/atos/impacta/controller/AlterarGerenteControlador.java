package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.model.Gerente;
import br.atos.impacta.repository.RepositorioGerente;
import br.atos.impacta.view.CadastroGerente;

public class AlterarGerenteControlador implements ActionListener {

	JTextField jTextField;
	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;

	RepositorioGerente repositorio;

	public AlterarGerenteControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioGerente repositorio,
			JTextField idjTextField) {
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
			JOptionPane.showMessageDialog(null, "Gerente localizado com sucesso.");
			jFrameAtual.setVisible(false);
			Gerente gerente = repositorio.listarGerentes().stream().filter(g -> g.getCpf().equals(id)).findFirst()
					.orElse(null);
			CadastroGerente cadastroGerente = new CadastroGerente(jFrameAtual, repositorio, gerente);
			cadastroGerente.showMenu();
		} else {
			JOptionPane.showMessageDialog(null, "Gerente não cadastrado.");
		}

	}

}
