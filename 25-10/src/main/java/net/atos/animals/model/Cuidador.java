package net.atos.animals.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbom_cuidador")
public class Cuidador implements Serializable {

	private static final long serialVersionUID = -8416392619539141709L;

	@Id
	@GenericGenerator(name = "vc_matricula", strategy = "net.atos.animals.utils.CuidadorIdGenerator")
	@GeneratedValue(generator = "vc_matricula", strategy = GenerationType.IDENTITY)
	@Column(name = "vc_matricula")
	private String matricula;

	@Column(name = "vc_nome")
	private String nome;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
