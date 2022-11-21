package br.atos.impacta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.model.Endereco;
import br.atos.impacta.repository.RepositorioCoordenador;

public class CadastroCoordenadorControlador implements ActionListener {

	RepositorioCoordenador repositorio;

	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;
	boolean edit = false;

	JTextField nomeJTextField;
	JTextField cpfJTextField;
	JTextField lojaJTextField;
	JTextField metaDaLojaJTextField;
	JTextField horasTrabJTextField;
	
	JTextField estadoJTextField;
	JTextField ruaJTextField;
	JTextField casaJTextField;
	int enderecoId;

	public CadastroCoordenadorControlador(JFrame jFrameAtual, JFrame jFrameMenuInicial,
			RepositorioCoordenador repositorio, JTextField nomeJTextField, JTextField cpfJTextField,
			JTextField lojaJTextField, JTextField metaDaLojaJTextField, JTextField horasTrabJTextField, JTextField estadoJTextField,
			JTextField ruaJTextField, JTextField casaJTextField, int enderecoId, Boolean edit) {
		super();
		this.jFrameAtual = jFrameAtual;
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
		this.nomeJTextField = nomeJTextField;
		this.cpfJTextField = cpfJTextField;
		this.lojaJTextField = lojaJTextField;
		this.metaDaLojaJTextField = metaDaLojaJTextField;
		this.horasTrabJTextField = horasTrabJTextField;
		this.estadoJTextField = estadoJTextField;
		this.ruaJTextField = ruaJTextField;
		this.casaJTextField = casaJTextField;
		this.enderecoId = enderecoId;
		this.edit = edit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.edit) {
			if (repositorio.verificarDuplicidade(cpfJTextField.getText())) {
				JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
			} else {
				if (this.save()) {
					jFrameAtual.setVisible(false);
					jFrameMenuInicial.setVisible(true);
				}
			}
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
			return false;
		}

		try {
			coordenador.calculaSalario(Double.valueOf(horasTrabJTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Horas trabalhadas inválidas.");
			return false;
		}
		
		Endereco endereco = new Endereco();
		endereco.setEstado(estadoJTextField.getText());
		endereco.setRua(ruaJTextField.getText());
		endereco.setCasa(casaJTextField.getText());
		endereco.setId(enderecoId);
		coordenador.setEndereco(endereco);
		if (!this.edit) {
			if (repositorio.salvarCoordenador(coordenador)) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar.");
				return false;
			}
		} else {
			if (repositorio.alterarCoordenador(coordenador, cpfJTextField.getText())) {
				JOptionPane.showMessageDialog(null, "Coordenador atualizado com sucesso.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao atualizar.");
				return true;
			}
		}
	}

}
