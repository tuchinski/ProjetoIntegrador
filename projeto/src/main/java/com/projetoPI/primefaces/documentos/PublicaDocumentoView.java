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

import com.projetoPI.model.DBFile;
import com.projetoPI.service.DBFileStorageService;

@ManagedBean
@ViewScoped
public class PublicaDocumentoView {
	private List<DBFile> arquivos;

	private DBFile arquivoSelecionado;
	
	@Autowired
	private DBFileStorageService dbFileStorageService;

	private StreamedContent streamedContent;

	public void onRowSelect(SelectEvent event) {
		this.arquivoSelecionado = ((DBFile) event.getObject());
		System.out.println(arquivoSelecionado.getFile_name());

		createStream(arquivoSelecionado);

	}

	private StreamedContent createStream(DBFile arquivoSelecionado) {
		InputStream arrayDadosArquivo = new ByteArrayInputStream(arquivoSelecionado.getData());
		this.streamedContent = new DefaultStreamedContent(arrayDadosArquivo, arquivoSelecionado.getFile_type(),
				arquivoSelecionado.getFile_name());
		return this.streamedContent;
	}

	public String generateRandomIdForNotCaching() {
		return java.util.UUID.randomUUID().toString();
	}

	public void publicaDocumento(DBFile arquivo) {
		arquivo.setPublicado(true);
		dbFileStorageService.editaFile(arquivo);
		System.out.println("Publicou" + arquivo.isPublicado());
	}

	public void rejeitaPublicacaoDocumento(DBFile arquivo) {
		System.out.println("Rejeitou publicacao" + arquivo.getFile_name());
	}

/////getters e setters//////////////////////////////

	public DBFile getNomeArquivoSelecionado() {
		return arquivoSelecionado;
	}

	public void setNomeArquivoSelecionado(DBFile nomeArquivoSelecionado) {
		this.arquivoSelecionado = nomeArquivoSelecionado;
	}

	public List<DBFile> getArquivos() {
		System.out.println("getArquivosPublica");
		return dbFileStorageService.getAllFileParaPublicacao();
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
}
