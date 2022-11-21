package br.atos.impacta.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Telas {

	public void showMenu();
	public JPanel createPanel(JFrame jFrame);
	public String createMenuOptions();
}
