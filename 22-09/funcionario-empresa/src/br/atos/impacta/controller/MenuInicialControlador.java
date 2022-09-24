package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.impacta.view.CadastroCoordenador;
import br.atos.impacta.view.CadastroGerente;

public class MenuInicialControlador implements ActionListener {

	private JTextField jTextFieldOpt;
	private JFrame jFrameDefault;

	public MenuInicialControlador(JTextField _jTextField, JFrame _jFrame) {
		this.jFrameDefault = _jFrame;
		this.jTextFieldOpt = _jTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (jTextFieldOpt.getText()) {
		case "1": // Gerente
			jFrameDefault.setVisible(false);
			CadastroGerente cadastroGerente = new CadastroGerente(jFrameDefault);
			cadastroGerente.showMenu();

			System.out.println("Cadastrar gerente");
			break;
		case "2": // Gerente
			jFrameDefault.setVisible(false);
			CadastroCoordenador cadastroCoordenador = new CadastroCoordenador(jFrameDefault);
			cadastroCoordenador.showMenu();

			System.out.println("Cadastrar coordenador");
			break;
		case "3": // Listar func

			jFrameDefault.setVisible(false);
			System.out.println("Listar");
			break;

		case "0":
			System.out.println("Saindo...");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

}
