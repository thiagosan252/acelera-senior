package br.atos.impacta.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.impacta.model.Gerente;
import br.atos.impacta.repository.RepositorioGerente;

public class ListarGerente implements Telas {

	private final String MENU_TOP_LABEL = "Lista de Gerentes";
	JFrame jFrameMenuInicial;
	RepositorioGerente repositorioGerente;

	public ListarGerente(JFrame jFrameMenuInicial, RepositorioGerente repositorioGerente) {
		super();
		this.jFrameMenuInicial = jFrameMenuInicial;
		this.repositorioGerente = repositorioGerente;
	}

	@Override
	public void showMenu() {

		JFrame jFrame = new JFrame();
		jFrame.setSize(500, 600);
		jFrame.setTitle(MENU_TOP_LABEL);

		jFrame.add(createPanel(jFrame));

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);

	}

	@Override
	public JPanel createPanel(JFrame jFrame) {
		List<Gerente> lista = repositorioGerente.listarGerentes();
		String colunas[] = { "Nome", "CPF", "Regional", "Meta Regional", "Salário Liquido" };

		String[][] linhas = new String[lista.size()][colunas.length];

		this.fillTable(lista, linhas);
		JTable tabela = new JTable(linhas, colunas);
		tabela.setBounds(30, 40, 200, 300);

		JScrollPane jScrollPane = new JScrollPane(tabela);
		JPanel jPanel = new JPanel();
		jPanel.add(jScrollPane);

		return jPanel;
	}

	@Override
	public String createMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void fillTable(List<Gerente> lista, String[][] linhas) {
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for(Gerente gerente: lista) {
			
			linhas [posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			
			linhas [posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;
			
			linhas [posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna++;
			
			linhas [posicaoLinha][posicaoColuna] = gerente.getMetaRegional().toString();
			posicaoColuna++;
			
			linhas [posicaoLinha][posicaoColuna] = gerente.getSalarioLiquido().toString();		
			posicaoColuna = 0;
			posicaoLinha++;
		
		}
	}

}
