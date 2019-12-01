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
public class BuscaCompendioView {


	@SuppressWarnings("unused")
	private List<Compendio> compendios;
	
	private Compendio selectedCompendio;
	
	@SuppressWarnings("unused")
	private List<DBFile> documentosCompendio;
	
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
	
	public void onRowSelect(SelectEvent event) {		
		System.out.println("BUSCA COMPENDIO");
		this.arquivoSelecionado = ((DBFile) event.getObject());	
		System.out.println(arquivoSelecionado.getFile_name());
		
		createStream(arquivoSelecionado);

	}
	
	
	private StreamedContent createStream(DBFile arquivoSelecionado) {
		InputStream arrayDadosArquivo = new ByteArrayInputStream(arquivoSelecionado.getData());
		this.streamedContent = new DefaultStreamedContent(arrayDadosArquivo, arquivoSelecionado.getFile_type(), arquivoSelecionado.getFile_name());
		return this.streamedContent;
	}
	
//	public void aa(DBFile arquivo) {
//		System.out.println("!!aa!!" + arquivo);
//	}
	

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
	public String generateRandomIdForNotCaching() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	
	
}
