package br.atos.impacta.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.impacta.controller.CadastroCoordenadorControlador;
import br.atos.impacta.model.Coordenador;
import br.atos.impacta.repository.RepositorioCoordenador;

public class CadastroCoordenador implements Telas {

	private final String MENU_TOP_LABEL = "Cadastro de Coordenador";
	private final String MENU_SEND_BUTTON_TEXT = "Salvar";
	private final String MENU_BACK_BUTTON_TEXT = "Voltar";
	private final int COLUMNS = 10;

	JFrame jFrameAtual;
	JFrame jFrameMenuInicial;
	RepositorioCoordenador repositorio;
	Coordenador coordenador;

	public CadastroCoordenador(JFrame jFrameMenuInicial, RepositorioCoordenador repositorio, Coordenador coordenador) {
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
		this.coordenador = coordenador;
	}

	@Override
	public void showMenu() {

		jFrameAtual = new JFrame();
		jFrameAtual.setSize(150, 550);
		jFrameAtual.setTitle(MENU_TOP_LABEL);
		jFrameAtual.setLocation(300, 300);
		jFrameAtual.add(createPanel(jFrameAtual));
		jFrameAtual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrameAtual.setVisible(true);

	}

	@Override
	public JPanel createPanel(JFrame jFrame) {
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField jTextField = new JTextField(COLUMNS);
		JTextField jTextField1 = new JTextField(COLUMNS);
		JTextField jTextField2 = new JTextField(COLUMNS);
		JTextField jTextField3 = new JTextField(COLUMNS);
		JTextField jTextField4 = new JTextField(COLUMNS);

		// endereco
		JTextField jTextField5 = new JTextField(COLUMNS);
		JTextField jTextField6 = new JTextField(COLUMNS);
		JTextField jTextField7 = new JTextField(COLUMNS);

		if (this.coordenador == null) {
			jPanel.add(new JLabel("Nome:"));
			jPanel.add(jTextField);

			jPanel.add(new JLabel("CPF:"));
			jPanel.add(jTextField1);

			jPanel.add(new JLabel("Loja:"));
			jPanel.add(jTextField2);

			jPanel.add(new JLabel("Meta da Loja:"));
			jPanel.add(jTextField3);

			jPanel.add(new JLabel("Horas Trabalhadas:"));
			jPanel.add(jTextField4);

			// endereco
			jPanel.add(new JLabel("Estado:"));
			jPanel.add(jTextField5);

			jPanel.add(new JLabel("Rua:"));
			jPanel.add(jTextField6);

			jPanel.add(new JLabel("Número da Casa:"));
			jPanel.add(jTextField7);
		} else {
			jPanel.add(new JLabel("Nome:"));
			jTextField.setText(coordenador.getNome());
			jPanel.add(jTextField);

			jPanel.add(new JLabel("CPF:"));
			jTextField1.setText(coordenador.getCpf());
			jTextField1.setEditable(false);
			jPanel.add(jTextField1);

			jPanel.add(new JLabel("Loja:"));
			jTextField2.setText(coordenador.getLoja());
			jPanel.add(jTextField2);

			jPanel.add(new JLabel("Meta da Loja:"));
			jTextField3.setText(coordenador.getMetaDaLoja().toString());
			jPanel.add(jTextField3);

			jPanel.add(new JLabel("Horas Trabalhadas:"));
			jPanel.add(jTextField4);

			// endereco
			jPanel.add(new JLabel("Estado:"));
			jTextField5.setText(coordenador.getEndereco().getEstado());
			jPanel.add(jTextField5);

			jPanel.add(new JLabel("Rua:"));
			jTextField6.setText(coordenador.getEndereco().getRua());
			jPanel.add(jTextField6);

			jPanel.add(new JLabel("Número da Casa:"));
			jTextField7.setText(coordenador.getEndereco().getCasa());
			jPanel.add(jTextField7);
		}

		JButton jButton = new JButton(MENU_SEND_BUTTON_TEXT);
		jPanel.add(jButton);

		CadastroCoordenadorControlador cadastroCoordenadorControlador = new CadastroCoordenadorControlador(jFrame,
				this.jFrameMenuInicial, this.repositorio, jTextField, jTextField1, jTextField2, jTextField3,
				jTextField4, jTextField5, jTextField6, jTextField7, this.coordenador.getEndereco().getId(), (coordenador != null) ? true : false);
		jButton.addActionListener(cadastroCoordenadorControlador);

		JButton jButton1 = new JButton(MENU_BACK_BUTTON_TEXT);
		jPanel.add(jButton1);
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrameAtual.setVisible(false);
				jFrameMenuInicial.setVisible(true);
			}
		});

		return jPanel;
	}

	@Override
	public String createMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
