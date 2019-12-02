package com.projetoPI.primefaces.documentos;



import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetoPI.model.DBFile;
import com.projetoPI.service.DBFileStorageService;

@ManagedBean
@ViewScoped
public class HomeView {

	private DBFile arquivoSelecionado;
	
	private List<DBFile> arquivos;
	
	
	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	private StreamedContent streamedContent;

	public void onRowSelect(SelectEvent event) {		
		System.out.println("HOME VIEW - ONROWSELECT!!!!!!!!");
		this.arquivoSelecionado = ((DBFile) event.getObject());	
		System.out.println(arquivoSelecionado.getFile_name());
		
		createStream(arquivoSelecionado);

	}
	
	private StreamedContent createStream(DBFile arquivoSelecionado) {
		InputStream arrayDadosArquivo = new ByteArrayInputStream(arquivoSelecionado.getData());
		this.streamedContent = new DefaultStreamedContent(arrayDadosArquivo, arquivoSelecionado.getFile_type(), arquivoSelecionado.getFile_name());
		return this.streamedContent;
	}	
	
	public String generateRandomIdForNotCaching() {
		return java.util.UUID.randomUUID().toString();
	}
	
		
/////getters e setters//////////////////////////////

	public DBFile getNomeArquivoSelecionado() {
		return arquivoSelecionado;
	}

	public void setNomeArquivoSelecionado(DBFile nomeArquivoSelecionado) {
		this.arquivoSelecionado = nomeArquivoSelecionado;
	}

	public List<DBFile> getArquivos() {
//		return dbFileStorageService.getAllFile();
		System.out.println("heey");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		
		//pega o nome do usuário
		System.out.println("Usuário: " + ((UserDetails)principal).getUsername());
		
		return dbFileStorageService.getAllFileValidado();
		

	}

	public void setArquivos(List<DBFile> arquivos) {
		this.arquivos = arquivos;
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	
/////////////////////////////////////////////////////////////////////////////////
}
