package com.projetoPI.primefaces.compendio;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.service.CompendioStorageService;
import com.projetoPI.service.DBFileStorageService;

@Named
@Scope("view")
public class BuscaCompendioView {


	private List<Compendio> compendios;
	
	private Compendio selectedCompendio;
	
	private List<DBFile> documentosCompendio;

	@Autowired
	private CompendioStorageService compendioStorageService;

	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	public void testa(Compendio c) {
		System.out.println("entrou Testa");
		System.out.println(c.getNome());
		this.selectedCompendio = c;

	}
	

	public List<DBFile> getDocumentosCompendio() {
		System.out.println("getDOcsCompendio");
//		return dbFileStorageService.findByCompendio(this.selectedCompendio);
		if(this.selectedCompendio == null) {
			return null;
		}
		return this.selectedCompendio.getListaArquivos();
	}
	
	public List<Compendio> getCompendios() {
		return compendioStorageService.getAllCompendio();
	}

	public void setCompendios(List<Compendio> compendios) {
		this.compendios = compendios;
	}
	
	
	
}
