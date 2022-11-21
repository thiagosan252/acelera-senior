package br.atos.impacta.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.impacta.model.Coordenador;
import br.atos.impacta.repository.RepositorioCoordenador;

public class ListarCoordenador implements Telas {

	private final String MENU_TOP_LABEL = "Lista de Coordenadores";
	private final String MENU_BACK_BUTTON_TEXT = "Voltar";

	JFrame jFrameMenuInicial;
	JFrame jFrameAtual;
	RepositorioCoordenador repositorio;

	public ListarCoordenador(JFrame jFrameMenuInicial, RepositorioCoordenador repositorio) {
		super();
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorio = repositorio;
	}

	@Override
	public void showMenu() {

		jFrameAtual = new JFrame();
		jFrameAtual.setSize(500, 600);
		jFrameAtual.setTitle(MENU_TOP_LABEL);
		jFrameAtual.add(createPanel(jFrameAtual));
		jFrameAtual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrameAtual.setVisible(true);

	}

	@Override
	public JPanel createPanel(JFrame jFrame) {
		List<Coordenador> lista = repositorio.listarCoordenadores();
		String colunas[] = { "Nome", "CPF", "Loja", "Meta Loja", "Salário Liquido", "Endereço" };

		Object[][] linhas = new Object[lista.size()][colunas.length];

		this.fillTable(lista, linhas);

		JTable jTable = new JTable(linhas, colunas);
		jTable.setBounds(30, 40, 200, 300);

		JScrollPane jScrollPane = new JScrollPane(jTable);
		JPanel jPanel = new JPanel();
		jPanel.add(jScrollPane);

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

	private void fillTable(List<Coordenador> lista, Object[][] linhas) {
		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Coordenador coordenador : lista) {

			linhas[posicaoLinha][posicaoColuna] = coordenador.getNome().toUpperCase();
			posicaoColuna++;

			linhas[posicaoLinha][posicaoColuna] = coordenador.getCpf();
			posicaoColuna++;

			linhas[posicaoLinha][posicaoColuna] = coordenador.getLoja().toUpperCase();
			posicaoColuna++;

			linhas[posicaoLinha][posicaoColuna] = coordenador.getMetaDaLoja().toString();
			posicaoColuna++;

			linhas[posicaoLinha][posicaoColuna] = "R$ " + new BigDecimal(coordenador.getSalarioLiquido())
					.setScale(2, RoundingMode.HALF_EVEN).toPlainString();
			posicaoColuna++;

			if (coordenador.getEndereco().getRua() != null && coordenador.getEndereco().getEstado() != null
					&& coordenador.getEndereco().getRua() != null) {
				linhas[posicaoLinha][posicaoColuna] = coordenador.getEndereco().getRua() + ", "
						+ coordenador.getEndereco().getCasa() + " - " + coordenador.getEndereco().getEstado();
			} else {
				linhas[posicaoLinha][posicaoColuna] = "";
			}

			posicaoColuna = 0;
			posicaoLinha++;

		}
	}

}
