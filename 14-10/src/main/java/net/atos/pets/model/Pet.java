package net.atos.pets.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbom_pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = -6286293616549504048L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ni_cod")
	private long id;

	@Column(name = "vc_nome")
	private String nome;

	@Column(name = "vc_especie")
	private String especie;

	@Column(name = "vc_raca")
	private String raca;

	@Column(name = "ni_idade")
	private int idade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
