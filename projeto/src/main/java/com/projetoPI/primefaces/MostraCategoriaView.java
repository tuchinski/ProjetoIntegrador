package com.projetoPI.primefaces;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Categoria;
import com.projetoPI.model.Setor;
import com.projetoPI.service.CategoriaStorageService;

@Named
@Scope("view")
public class MostraCategoriaView {
	private String nomeCategoria;
	
	private Categoria categoriaEdit;

	private List<Categoria> categorias;
	
	@Autowired
	private CategoriaStorageService service;
	
	

	public Categoria getCategoriaEdit() {
		return categoriaEdit;
	}

	public void setCategoriaEdit(Categoria categoriaEdit) {
		this.categoriaEdit = categoriaEdit;
	}

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

	public void editarLinhaCat(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editar Categoria");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void editarCat(Categoria c) {
		System.out.println(c.getNomeCategoria());
		this.categoriaEdit = c;
	}
}