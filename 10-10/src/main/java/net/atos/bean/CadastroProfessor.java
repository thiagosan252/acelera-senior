package net.atos.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.atos.model.Endereco;
import net.atos.model.Pessoa;
import net.atos.model.Professor;
import net.atos.persistencia.EnderecoDAO;
import net.atos.persistencia.PessoaDAO;
import net.atos.persistencia.ProfessorDAO;

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

	@PostConstruct
	public void carregaPagina() {
		carregarProfessores();
	}

	private void carregarProfessores() {
		this.limparCampos();
		setListaProfessores(ProfessorDAO.buscar(null));
	}

	public String cadastrar() {

		Endereco endereco = new Endereco();
		Professor professor = new Professor();

		try {
			professor.setSalario(Double.valueOf(salario));
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Salário com formato inválido",
					"Cadastro não realizado. Salário com formato inválido");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}

		try {

			endereco.setCidade(cidade);
			endereco.setNumero(numero);
			endereco.setRua(rua);

			professor.setDisciplina(disciplina);
			professor.setEndereco(endereco);

			Long enderecoId = EnderecoDAO.salvarEndereco(endereco);
			if (enderecoId != null) {
				endereco.setId(enderecoId.intValue());
				Long pessoaId = PessoaDAO.cadastrar(new Pessoa(nome, cpf, endereco));
				if (ProfessorDAO.salvar(professor, pessoaId.intValue())) {
					carregarProfessores();
				}
			}

		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cadastro não realizado. Erro ao salvar no banco de dados",
					"Cadastro não realizado. Erro ao salvar no banco de dados");
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

	public void remover(Professor professor) {
		try {
			PessoaDAO.deletar(professor.getCpf());
			carregarProfessores();
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao remover professor " + professor.getNome(),
					"Erro ao remover professor " + professor.getNome());
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
