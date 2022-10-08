package net.atos.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.atos.model.Endereco;
import net.atos.model.Professor;

@ManagedBean(name = "cadastroProfessor")
@SessionScoped
public class CadastroProfessor {

	private String nome;
	private String cpf;
	private String cidade;
	private String rua;
	private String numero;
	private String disciplina;
	private String salario;
	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public String cadastrar() {

		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setCpf(cpf);
		professor.setDisciplina(disciplina);
		professor.setEndereco(endereco);
		try {
			professor.setSalario(Double.valueOf(salario));
			listaProfessores.add(professor);
			this.limparCampos();
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Salário com formato inválido",
					"Cadastro não realizado. Salário com formato inválido");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return "cadastroProfessor.xhtml";
	}

	public void limparCampos() {
		this.setNome("");
		this.setCpf("");
		this.setCidade("");
		this.setRua("");
		this.setNumero("");
		this.setDisciplina("");
		this.setSalario(null);
	}

	public String remover(Professor professor) {
		listaProfessores.remove(professor);
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

}
