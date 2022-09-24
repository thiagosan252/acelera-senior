package br.atos.impacta.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.impacta.controller.CadastroCoordenadorControlador;
import br.atos.impacta.repository.RepositorioCoordenador;

public class CadastroCoordenador implements Telas {

	private final String MENU_TOP_LABEL = "Cadastro de Coordenador";
	private final String MENU_SEND_BUTTON_TEXT = "Salvar";
	private final int COLUMNS = 10;

	JFrame jFrameMenuInicial;
	RepositorioCoordenador repositorioCoordenador;

	public CadastroCoordenador(JFrame jFrameMenuInicial, RepositorioCoordenador repositorioCoordenador) {
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorioCoordenador = repositorioCoordenador;
	}

	@Override
	public void showMenu() {

		JFrame jFrame = new JFrame();
		jFrame.setSize(200, 200);
		jFrame.setTitle(MENU_TOP_LABEL);
		jFrame.setLocation(300, 300);
		jFrame.add(createPanel(jFrame));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);

	}

	@Override
	public JPanel createPanel(JFrame jFrame) {
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		jPanel.add(new JLabel("Nome:"));
		JTextField jTextField = new JTextField(COLUMNS);
		jPanel.add(jTextField);

		jPanel.add(new JLabel("CPF:"));
		JTextField jTextField1 = new JTextField(COLUMNS);
		jPanel.add(jTextField1);

		jPanel.add(new JLabel("Loja:"));
		JTextField jTextField2 = new JTextField(COLUMNS);
		jPanel.add(jTextField2);

		jPanel.add(new JLabel("Meta da Loja:"));
		JTextField jTextField3 = new JTextField(COLUMNS);
		jPanel.add(jTextField3);

		jPanel.add(new JLabel("Horas Trabalhadas:"));
		JTextField jTextField4 = new JTextField(COLUMNS);
		jPanel.add(jTextField4);

		JButton jButton = new JButton(MENU_SEND_BUTTON_TEXT);
		jPanel.add(jButton);

		CadastroCoordenadorControlador cadastroCoordenadorControlador = new CadastroCoordenadorControlador(jFrame,
				this.jFrameMenuInicial, this.repositorioCoordenador, jTextField, jTextField1, jTextField2, jTextField3, jTextField4);

		jButton.addActionListener(cadastroCoordenadorControlador);

		return jPanel;
	}

	@Override
	public String createMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
