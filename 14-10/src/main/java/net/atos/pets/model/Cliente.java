package net.atos.pets.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbom_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 981711159424222134L;

	@Column(name = "vc_nome")
	private String nome;

	@Id
	@Column(name = "vc_cpf")
	private String cpf;

	@Column(name = "ni_idade")
	private int idade;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.REFRESH)
	private List<Pet> pets;

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
