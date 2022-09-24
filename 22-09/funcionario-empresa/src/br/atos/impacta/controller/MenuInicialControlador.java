package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.repository.RepositorioCoordenador;
import br.atos.impacta.repository.RepositorioGerente;
import br.atos.impacta.view.AlterarCoordenador;
import br.atos.impacta.view.AlterarGerente;
import br.atos.impacta.view.CadastroCoordenador;
import br.atos.impacta.view.CadastroGerente;
import br.atos.impacta.view.DeletarCoordenador;
import br.atos.impacta.view.DeletarGerente;
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
			CadastroGerente cadastroGerente = new CadastroGerente(jFrameDefault, repositorioGerente, null);
			cadastroGerente.showMenu();
			break;
		case "2": // Cadastrar coordenador
			jFrameDefault.setVisible(false);
			CadastroCoordenador cadastroCoordenador = new CadastroCoordenador(jFrameDefault, repositorioCoordenador, null);
			cadastroCoordenador.showMenu();
			break;
		case "3": // Listar Gerentes
			jFrameDefault.setVisible(false);
			ListarGerente listarGerente = new ListarGerente(jFrameDefault, repositorioGerente);
			listarGerente.showMenu();
			break;
		case "4": // Listar Coordenadores
			jFrameDefault.setVisible(false);
			ListarCoordenador listarCoordenador = new ListarCoordenador(jFrameDefault, repositorioCoordenador);
			listarCoordenador.showMenu();
			break;
		case "5": // deletar Gerente
			jFrameDefault.setVisible(false);
			DeletarGerente deletarGerente = new DeletarGerente(jFrameDefault, repositorioGerente);
			deletarGerente.showMenu();
			break;
		case "6": // deletar coordenador
			jFrameDefault.setVisible(false);
			DeletarCoordenador deletarCoordenador = new DeletarCoordenador(jFrameDefault, repositorioCoordenador);
			deletarCoordenador.showMenu();
			break;
		case "7": // alterar Gerente
			jFrameDefault.setVisible(false);
			AlterarGerente alterarGerente = new AlterarGerente(jFrameDefault, repositorioGerente);
			alterarGerente.showMenu();
			break;
		case "8": // alterar coordenador
			jFrameDefault.setVisible(false);
			AlterarCoordenador alterarCoordenador = new AlterarCoordenador(jFrameDefault, repositorioCoordenador);
			alterarCoordenador.showMenu();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida.");
			break;
		}
		
		jTextFieldOpt.setText("");
	}

}
