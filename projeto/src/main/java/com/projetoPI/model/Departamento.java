package com.projetoPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity(name = "Departamento")
@Table(name = "departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departamento_id")
	private long departamento_id;
	
	@NotNull
	private String nome_departamento;

	public Departamento(@NotNull String depto) {
		super();
		this.nome_departamento = depto;
	}

	public String getNomeSetor() {
		return nome_departamento;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nome_departamento = nomeSetor; 
	}

	public long getSetor_id() {
		return departamento_id;
	}

	public void setSetor_id(long setor_id) {
		this.departamento_id = setor_id;
	}	
	
}

