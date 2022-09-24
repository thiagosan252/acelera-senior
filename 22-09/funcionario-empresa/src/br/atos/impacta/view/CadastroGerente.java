package br.atos.impacta.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.impacta.controller.CadastroGerenteControlador;

public class CadastroGerente implements Telas {

	private final String MENU_TOP_LABEL = "Cadastro de Gerente";
	private final String MENU_SEND_BUTTON_TEXT = "Salvar";
	private final int COLUMNS = 10;

	JFrame jFrameMenuInicial;

	public CadastroGerente(JFrame jFrameMenuInicial) {
		this.jFrameMenuInicial = jFrameMenuInicial;
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

		jPanel.add(new JLabel("Regional:"));
		JTextField jTextField2 = new JTextField(COLUMNS);
		jPanel.add(jTextField2);

		jPanel.add(new JLabel("Meta Regional:"));
		JTextField jTextField3 = new JTextField(COLUMNS);
		jPanel.add(jTextField3);

		jPanel.add(new JLabel("Horas Trabalhadas:"));
		JTextField jTextField4 = new JTextField(COLUMNS);
		jPanel.add(jTextField4);

		JButton jButton = new JButton(MENU_SEND_BUTTON_TEXT);
		jPanel.add(jButton);

		CadastroGerenteControlador cadastroGerenteControlador = new CadastroGerenteControlador(jFrame,
				this.jFrameMenuInicial, jTextField, jTextField1, jTextField2, jTextField3, jTextField4);

		jButton.addActionListener(cadastroGerenteControlador);

		return jPanel;
	}

	@Override
	public String createMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}
}
