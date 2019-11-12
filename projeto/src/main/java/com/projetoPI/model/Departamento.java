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

	public Departamento() {
		super();
	}

	public Departamento(@NotNull String depto) {
		super();
		this.nome_departamento = depto;
	}

	public long getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(long departamento_id) {
		this.departamento_id = departamento_id;
	}

	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}

	
	
}

