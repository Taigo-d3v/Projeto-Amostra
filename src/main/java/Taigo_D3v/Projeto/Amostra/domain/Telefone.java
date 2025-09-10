package Taigo_D3v.Projeto.Amostra.domain;

import jakarta.persistence.*;

@Embeddable
public class Telefone {

	private Integer numero;

	public Telefone() {
	}

	public Telefone(Integer numero) {
		super();
		this.numero = numero;
	}

	// Getters e Setters

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
