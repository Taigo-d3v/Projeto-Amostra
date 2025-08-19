package Taigo_D3v.Projeto.Amostra.domain;

import jakarta.persistence.*;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	String nome;
	
	@ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

	//Construtores
	public Cidade() {
		
	}
	
	public Cidade(String nome) {
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
