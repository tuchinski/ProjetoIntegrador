package com.projetoPI.primefaces;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Categoria;


import com.projetoPI.service.CategoriaStorageService;

@Named
@Scope("view")
public class MostraCategoriaView {
	private String nomeCategoria;
	
	private List<Categoria> categorias;
	
	@Autowired
	private CategoriaStorageService service;

	public String getNomeSetor() {
		return nomeCategoria;
	}

	public void setNomeSetor(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Categoria> getCategorias() {
		return service.getAllCategorias();
	}

	public void setSetores(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}