package com.projetoPI.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "compendio")
public class Compendio {
	@Id
	@Column(name = "compendio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	private String nome;
	
	@OneToMany(mappedBy = "compendios", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER )
	List<DBFile> listaArquivos;
	
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Compendio() {
		super();
	}

	public Compendio(@NotNull String nome, List<DBFile> listaArquivos) {
		super();
		this.nome = nome;
		this.listaArquivos = listaArquivos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DBFile> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(List<DBFile> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	

}
