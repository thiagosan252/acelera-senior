package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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

	public CadastroCoordenadorControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial, RepositorioCoordenador repositorio, JTextField nomeJTextField,
			JTextField cpfJTextField, JTextField lojaJTextField, JTextField metaDaLojaJTextField,
			JTextField horasTrabJTextField) {
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
		this.save();
		jFrameAtual.setVisible(false);
		jFrameMenuInicial.setVisible(true);
	}

	private void save() {
		Coordenador coordenador = new Coordenador();
		coordenador.setNome(nomeJTextField.getText());
		coordenador.setCpf(cpfJTextField.getText());
		coordenador.setLoja(lojaJTextField.getText());
		coordenador.setMetaDaLoja(Double.valueOf(metaDaLojaJTextField.getText()));
		coordenador.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));

		if (repositorio.salvarCoordenador(coordenador)) {
			System.out.println("Cadastrado com sucesso.");
		} else {
			System.out.println("Falha ao cadastrar.");
		}
	}

}
