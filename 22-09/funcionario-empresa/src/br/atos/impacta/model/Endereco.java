package br.atos.impacta.model;

public class Endereco {

	private int id;
	private String estado;
	private String rua;
	private String casa;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return "Endereco [estado = " + estado + ", rua = " + rua + ", casa = " + casa + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
