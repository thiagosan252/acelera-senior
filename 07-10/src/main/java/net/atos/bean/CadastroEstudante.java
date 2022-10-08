package net.atos.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.atos.model.Endereco;
import net.atos.model.Estudante;

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

	public String cadastrar() {

		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		Estudante estudante = new Estudante();
		estudante.setNome(nome);
		estudante.setCpf(cpf);
		estudante.setTurma(turma);
		estudante.setEndereco(endereco);
		try {
			estudante.setMedia(Double.valueOf(media));
			listaEstudantes.add(estudante);
			this.limparCampos();
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Média com formato inválido",
					"Cadastro não realizado. Média com formato inválido");
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
	
	public String remover(Estudante estudante) {
		listaEstudantes.remove(estudante);
		return "";
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
