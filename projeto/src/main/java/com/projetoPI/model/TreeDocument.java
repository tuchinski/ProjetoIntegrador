package com.projetoPI.model;

public class TreeDocument {
	private String nome;
	private String tamanho;
	private String tipo;
	private DBFile arquivo;
	
	public TreeDocument(String nome, String tamanho, String tipo) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.tipo = tipo;
	}
	
	
	public TreeDocument(String nome, String tamanho, String tipo, DBFile arquivo) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.tipo = tipo;
		this.arquivo = arquivo;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public DBFile getArquivo() {
		return arquivo;
	}
	public void setArquivo(DBFile arquivo) {
		this.arquivo = arquivo;
	}
	
	
}
