package com.projetoPI.primefaces;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Setor;
import com.projetoPI.service.SetorStorageService;

@Named
@Scope("view")
public class BuscaSetorView {
	private String nomeSetor;
	
	private List<Setor> setores;
	
	@Autowired
	private SetorStorageService service;

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public List<Setor> getSetores() {
		return service.getAllSetores();
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	
	
	
}
