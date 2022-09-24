package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioCoordenador;
import br.atos.impacta.repository.RepositorioGerente;
import br.atos.impacta.view.CadastroCoordenador;
import br.atos.impacta.view.CadastroGerente;
import br.atos.impacta.view.ListarCoordenador;
import br.atos.impacta.view.ListarGerente;

public class MenuInicialControlador implements ActionListener {

	private JTextField jTextFieldOpt;
	private JFrame jFrameDefault;
	
	RepositorioGerente repositorioGerente = new RepositorioGerente();
	RepositorioCoordenador repositorioCoordenador = new RepositorioCoordenador();

	public MenuInicialControlador(JTextField _jTextField, JFrame _jFrame) {
		super();
		this.jFrameDefault = _jFrame;
		this.jTextFieldOpt = _jTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (jTextFieldOpt.getText()) {
		case "1": // Cadastrar gerente
			jFrameDefault.setVisible(false);
			CadastroGerente cadastroGerente = new CadastroGerente(jFrameDefault, repositorioGerente);
			cadastroGerente.showMenu();
			break;
		case "2": //Cadastrar coordenador
			jFrameDefault.setVisible(false);
			CadastroCoordenador cadastroCoordenador = new CadastroCoordenador(jFrameDefault, repositorioCoordenador);
			cadastroCoordenador.showMenu();
			break;
		case "3": //Listar Gerentes
			jFrameDefault.setVisible(false);
			ListarGerente listarGerente = new ListarGerente(jFrameDefault, repositorioGerente);
			listarGerente.showMenu();
			
//			for (Gerente t : repositorioGerente.listarGerentes()) {
//				System.out.println(t.toString());
//			}
			break;
		case "4": // Listar Coordenadores
			jFrameDefault.setVisible(false);
			ListarCoordenador listarCoordenador = new ListarCoordenador(jFrameDefault, repositorioCoordenador);
			listarCoordenador.showMenu();
//			for (Coordenador t : repositorioCoordenador.listarCoordenadores()) {
//				System.out.println(t.toString());
//			}
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

