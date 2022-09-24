package br.atos.impacta.view;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.atos.impacta.controller.MenuInicialControlador;

public class MenuInicial implements Telas {

	private final String MENU_TOP_LABEL = "Cadastro de Funcionário";
	private final String MENU_OPTION_EXIT = "[0] Sair";
	private final String MENU_SEND_BUTTON_TEXT = "Enviar";
	private final int COLUMNS = 10;

	@Override
	public void showMenu() {

		JFrame jFrame = new JFrame();
		jFrame.setSize(200, 300);
		jFrame.setTitle(MENU_TOP_LABEL);
		jFrame.setLocation(300, 300);
		jFrame.add(createPanel(jFrame));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);

	}

	@Override
	public JPanel createPanel(JFrame jFrame) {
		JPanel jPanel = new JPanel();

		JLabel jLabel = new JLabel(createMenuOptions(), SwingConstants.CENTER);
		jPanel.add(jLabel);

		JTextField jTextField = new JTextField(COLUMNS);
		jPanel.add(jTextField);

		JButton jButton = new JButton(MENU_SEND_BUTTON_TEXT);
		jPanel.add(jButton);

		jPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		MenuInicialControlador menuInicialControlador = new MenuInicialControlador(jTextField, jFrame);

		jButton.addActionListener(menuInicialControlador);

		return jPanel;
	}

	@Override
	public String createMenuOptions() {
		List<String> options = Arrays.asList("Início", "[1] Cadastro do Gerente", "[2] Cadastro do Coordenador",
				"[3] Listar Gerentes", "[4] Listar Coordenadores", "[5] Deletar Gerente", "[6] Deletar Coordenador",
				MENU_OPTION_EXIT);
		String opts = "<html>";

		for (String op : options) {
			opts += op + "<br/>";
		}

		opts += "</html>";

		return opts;
	}

}
