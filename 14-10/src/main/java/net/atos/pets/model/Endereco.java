package net.atos.pets.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbom_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 5019961512086172846L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ni_cod")
	private long id;

	@Column(name = "vc_cidade")
	private String cidade;

	@Column(name = "vc_rua")
	private String rua;

	@Column(name = "ni_numero")
	private int numero;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
