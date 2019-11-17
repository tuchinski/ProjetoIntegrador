package com.projetoPI.primefaces.departamento;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Categoria;
import com.projetoPI.model.Departamento;
import com.projetoPI.service.DepartamentoStorageService;

@Named
@Scope("view")
public class BuscaDepartamentoView {
	private String nomeDepto;
	
	private Departamento deptoEdit;
	
	private List<Departamento> deptos;
	
	@Autowired
	private DepartamentoStorageService service;

	
	public Departamento getDeptoEdit() {
		return deptoEdit;
	}

	public void setDeptoEdit(Departamento deptoEdit) {
		this.deptoEdit = deptoEdit;
	}

	public String getNomeDepto() {
		return nomeDepto;
	}

	public void setNomeDepto(String nomeDepto) {
		this.nomeDepto = nomeDepto;
	}

	public List<Departamento> getDeptos() {
		return service.getAllDepartamento();
	}

	public void setDeptos(List<Departamento> deptos) {
		this.deptos = deptos;
	}

	public void chamaTelaDepto(Departamento d) {
		System.out.println(d.getNome_departamento());
		this.deptoEdit = d;
	}

	public void editaDepto() {
		System.out.println(this.deptoEdit.getNome_departamento());
		service.editaDepartamento(this.deptoEdit);
	}
	
	public void removeDepartamento(Departamento removeDepto) {
		service.removeDepartamento(removeDepto);
}
	
	
	
}
