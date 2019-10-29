package com.projetoPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Setor")
@Table(name = "setor")
public class Setor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "setor_id")
	private	long setor_id;
	
	private String nomeSetor;

	public Setor() {
		super();
	}

	public Setor(long setor_id, String nomeSetor) {
		super();
		this.setor_id = setor_id;
		this.nomeSetor = nomeSetor;
	}

	public Setor(String nomeSetor) {
		super();
		this.nomeSetor = nomeSetor;
	}

	public long getSetor_id() {
		return setor_id;
	}

	public void setSetor_id(long setor_id) {
		this.setor_id = setor_id;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	
	
	
	
	
}
