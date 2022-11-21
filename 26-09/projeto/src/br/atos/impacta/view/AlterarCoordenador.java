package br.atos.impacta.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.impacta.controller.AlterarCoordenadorControlador;
import br.atos.impacta.repository.RepositorioCoordenador;

public class AlterarCoordenador implements Telas {

	private final String MENU_TOP_LABEL = "Alterar Coordenador";
	private final String MENU_SEND_BUTTON_TEXT = "Buscar";
	private final String MENU_BACK_BUTTON_TEXT = "Voltar";
	private final int COLUMNS = 10;

	JFrame jFrameMenuInicial;
	JFrame jFrameAtual;
	RepositorioCoordenador repositorio;

	public AlterarCoordenador(JFrame jFrameMenuInicial, RepositorioCoordenador repositorio) {
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
	}

	@Override
	public void showMenu() {

		jFrameAtual = new JFrame();
		jFrameAtual.setSize(200, 200);
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

		jPanel.add(new JLabel("CPF:"));
		JTextField jTextField = new JTextField(COLUMNS);
		jPanel.add(jTextField);

		JButton jButton = new JButton(MENU_SEND_BUTTON_TEXT);
		jPanel.add(jButton);

		AlterarCoordenadorControlador alterarCoordenadorControlador = new AlterarCoordenadorControlador(jFrame,
				this.jFrameMenuInicial, this.repositorio, jTextField);

		jButton.addActionListener(alterarCoordenadorControlador);

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
