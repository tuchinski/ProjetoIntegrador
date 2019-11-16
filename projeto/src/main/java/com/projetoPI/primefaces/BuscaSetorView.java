package com.projetoPI.primefaces;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Setor;
import com.projetoPI.service.SetorStorageService;

@Named
@Scope("view")
public class BuscaSetorView {
	private String nomeSetor;
	
	private Setor setorEdit;
	
	public Setor getSetorEdit() {
		return setorEdit;
	}

	public void setSetorEdit(Setor setorEdit) {
		this.setorEdit = setorEdit;
	}

	private List<Setor> setores;
	
	@Autowired
	private SetorStorageService setorStorageService;

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public List<Setor> getSetores() {
		return setorStorageService.getAllSetores();
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	public void editarLinhaSet(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editar Setor");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void chamaTelaEditar(Setor s) {
		System.out.println(s.getNomeSetor());
		this.setorEdit = s;
	}
	
	public void editaSetor() {
		System.out.println(this.setorEdit.getNomeSetor());
		setorStorageService.editSetor(this.setorEdit);
	}
	

	public void deleteSetor(Setor setorDeleted) {
		System.out.println(setorDeleted.getNomeSetor());
		setorStorageService.deleteSetor(setorDeleted);
	}
	
	
	
}
