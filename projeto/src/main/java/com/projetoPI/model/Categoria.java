package com.projetoPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Categoria")
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "categoria_id")
	private String id;
	
	private String nomeCategoria;
	
	@OneToMany(mappedBy = "fileCategoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DBFile> documentos;


	public Categoria() {
		super();
	}
	
	public Categoria(String nomeCategoria) {
		super();
		if(nomeCategoria == null || nomeCategoria.length() == 0) {
			throw new IllegalArgumentException("Nome da categoria Vazio!!!!");
		}
		this.nomeCategoria = nomeCategoria;
	}

	public Categoria(String nomeCategoria, List<DBFile> documentos) {
		this(nomeCategoria);
		this.documentos = documentos;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public List<DBFile> getDocumentos() {
		return documentos;
	}
	
	
	public void setDocumentos(List<DBFile> documentos) {
		this.documentos = documentos;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nomeCategoria;
	}
}