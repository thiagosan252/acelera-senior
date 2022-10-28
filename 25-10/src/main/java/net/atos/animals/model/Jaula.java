package net.atos.animals.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbom_jaula")
public class Jaula implements Serializable {

	private static final long serialVersionUID = -3229237309227718851L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ni_cod")
	private long id;
	
	@Column(name = "vc_nomeZoologico")
	private String nomeZoologico;
	
	@Column(name = "vc_bloco")
	private String bloco;
	
	@Column(name = "vc_numeroDaJaula")
	private String numeroDaJaula;
	
	public String getNomeZoologico() {
		return nomeZoologico;
	}
	public void setNomeZoologico(String nomeZoologico) {
		this.nomeZoologico = nomeZoologico;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getNumeroDaJaula() {
		return numeroDaJaula;
	}
	public void setNumeroDaJaula(String numeroDaJaula) {
		this.numeroDaJaula = numeroDaJaula;
	}
	
	
}
