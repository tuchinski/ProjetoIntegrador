package com.projetoPI.primefaces.compendio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.service.CompendioStorageService;
import com.projetoPI.service.DBFileStorageService;

@Named
@Scope("view")
public class EditaCompendioView {


	@SuppressWarnings("unused")
	private List<Compendio> compendios;
	
	private Compendio selectedCompendio;
	
	@SuppressWarnings("unused")
	private List<DBFile> documentosCompendio;
	
	@SuppressWarnings("unused")
	private DBFile arquivoSelecionado;
	
	private StreamedContent streamedContent;

	@Autowired
	private CompendioStorageService compendioStorageService;

	@SuppressWarnings("unused")
	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	public void mostraDocsCompendio(Compendio c) {
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
	
	public void removeDocCompendio(DBFile arquivo) {
		
		System.out.println("peeeeeeeeeeey");
		arquivo.setCompendio(null);
		
		dbFileStorageService.editaFile(arquivo);
	}
	
	public void removeCompendio(Compendio c) {
		for (DBFile file : c.getListaArquivos() ) {
			file.setCompendio(null);
			dbFileStorageService.editaFile(file);
		}
		
		compendioStorageService.removeCompendio(c);
	}
	
	public void editaCompendio() {
		this.compendioStorageService.editaCompendio(this.selectedCompendio);
	}
	
	public List<Compendio> getCompendios() {
		return compendioStorageService.getAllCompendio();
	}

	public void setCompendios(List<Compendio> compendios) {
		this.compendios = compendios;
	}
	public String generateRandomIdForNotCaching() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public Compendio getSelectedCompendio() {
		return selectedCompendio;
	}

	
	
	
}
