package com.projetoPI.primefaces.compendio;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.primefaces.FacesUtil;
import com.projetoPI.service.CompendioStorageService;
import com.projetoPI.service.DBFileStorageService;

@ManagedBean
@ViewScoped
public class CadastraCompendioView {
    
    
    private String nomeCompendio;

    @SuppressWarnings("unused")
	private List<DBFile> listaArquivos;
    
    private List<DBFile> listaArquivosSelecionados;

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private CompendioStorageService compendioStorageService;
    

      
    public void criarCompendio() {
    	System.out.println("Criar compêndio");
    	System.out.println(this.listaArquivosSelecionados);
    	System.out.println(this.nomeCompendio);
    	Compendio novoCompendio = null;
    	try{
    		novoCompendio = compendioStorageService.storeCompendio(this.nomeCompendio, this.listaArquivosSelecionados);
    	}catch (IllegalArgumentException e) {
    		System.out.println("asdf");
    		System.out.println(e);
    		FacesUtil.addMsgInfo(e.getMessage());
    		return;
		}    	
    	
    	for (DBFile dbFile : listaArquivosSelecionados) {
			dbFile.setCompendio(novoCompendio);
		}
    	
    	dbFileStorageService.editaMultiplosFiles(this.listaArquivosSelecionados);
    	
    	
    	FacesUtil.addMsgInfo("Compêndo criado com sucesso");
    }
    


    /**
     * @return the nomeCompendio
     */
    public String getNomeCompendio() {
        return nomeCompendio;
    }

    /**
     * @param nomeCompendio the nomeCompendio to set
     */
    public void setNomeCompendio(String nomeCompendio) {
        this.nomeCompendio = nomeCompendio;
    }


    /**
     * @return the listaArquivos
     */
    public List<DBFile> getListaArquivos() {
        return this.dbFileStorageService.getAllFileSemCompendio();
    }

    /**
     * @param listaArquivos the listaArquivos to set
     */
    public void setListaArquivos(List<DBFile> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }

	public List<DBFile> getListaArquivosSelecionados() {
		return listaArquivosSelecionados;
	}

	public void setListaArquivosSelecionados(List<DBFile> listaArquivosSelecionados) {
		this.listaArquivosSelecionados = listaArquivosSelecionados;
	}
}