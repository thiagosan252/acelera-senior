package net.atos.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.atos.model.Endereco;
import net.atos.model.Estudante;
import net.atos.model.Pessoa;
import net.atos.persistencia.EnderecoDAO;
import net.atos.persistencia.EstudanteDAO;
import net.atos.persistencia.PessoaDAO;

@ManagedBean(name = "cadastroEstudante")
@SessionScoped
public class CadastroEstudante {

	private String nome;
	private String cpf;
	private String cidade;
	private String rua;
	private String numero;
	private String turma;
	private String media;
	private List<Estudante> listaEstudantes = new ArrayList<Estudante>();

	@PostConstruct
	public void carregaPagina() {
		carregarEstudantes();
	}

	private void carregarEstudantes() {
		this.limparCampos();
		setListaEstudantes(EstudanteDAO.buscar(null));
	}

	public String cadastrar() {

		Endereco endereco = new Endereco();
		Estudante estudante = new Estudante();

		try {
			estudante.setMedia(Double.valueOf(media));
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Média com formato inválido",
					"Cadastro não realizado. Média com formato inválido");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}

		try {

			endereco.setCidade(cidade);
			endereco.setNumero(numero);
			endereco.setRua(rua);

			estudante.setTurma(turma);
			estudante.setEndereco(endereco);

			Long enderecoId = EnderecoDAO.salvarEndereco(endereco);
			endereco.setId(enderecoId.intValue());
			if (enderecoId != null) {
				Long pessoaId = PessoaDAO.cadastrar(new Pessoa(nome, cpf, endereco));
				if (EstudanteDAO.salvar(estudante, pessoaId.intValue())) {
					carregarEstudantes();
				}
			}

		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Erro ao salvar no banco de dados",
					"Cadastro não realizado. Erro ao salvar no banco de dados");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return "cadastroEstudante.xhtml";
	}

	public void limparCampos() {
		this.setNome("");
		this.setCpf("");
		this.setCidade("");
		this.setRua("");
		this.setNumero("");
		this.setTurma("");
		this.setMedia(null);
	}

	public void remover(Estudante estudante) {
		try {
			PessoaDAO.deletar(estudante.getCpf());
			carregarEstudantes();
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao remover estudante " + estudante.getNome(),
					"Erro ao remover estudante " + estudante.getNome());
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public List<Estudante> getListaEstudantes() {
		return listaEstudantes;
	}

	public void setListaEstudantes(List<Estudante> listaEstudantes) {
		this.listaEstudantes = listaEstudantes;
	}

}
