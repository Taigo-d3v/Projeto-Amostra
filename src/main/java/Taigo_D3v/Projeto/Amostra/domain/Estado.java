package Taigo_D3v.Projeto.Amostra.domain;

import jakarta.persistence.*;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	String nome;
	
	//Construtores
	public Estado() {
		
	}
	public Estado(String nome) {

		this.nome = nome;
	}
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

