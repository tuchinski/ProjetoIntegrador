package com.projetoPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Setor")
@Table(name = "setor")
public class Setor {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY )
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "setor_id")
	private	long setor_id;
	
	@NotNull
	private String nomeSetor;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	@NotNull
	private Departamento setorDepartamento;

	public Setor() {
		super();
	}

	public Setor( long setor_id, String nomeSetor) {
		super();
		this.setor_id = setor_id;
		this.nomeSetor = nomeSetor;
	}
	
	

	public Setor(@NotNull String nomeSetor, @NotNull Departamento setorDepartamento) {
		super();
		this.nomeSetor = nomeSetor;
		this.setorDepartamento = setorDepartamento;
	}

	public Setor(String nomeSetor) {
		super();		
		if(nomeSetor == null||nomeSetor.length() == 0) {
			throw new IllegalArgumentException("O nome do setor não pode ser nulo ou vazio");
		}else {
			this.nomeSetor = nomeSetor;
		}
	
	}

	public long getSetor_id() {
		return this.setor_id;
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

	public Departamento getSetorDepartamento() {
		return setorDepartamento;
	}

	public void setSetorDepartamento(Departamento setorDepartamento) {
		this.setorDepartamento = setorDepartamento;
	}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nomeSetor;
	}
	
}
