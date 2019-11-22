package com.projetoPI.primefaces.compendio;

import java.util.List;

import com.projetoPI.model.DBFile;
import com.projetoPI.service.DBFileStorageService;

import org.springframework.beans.factory.annotation.Autowired;

public class CadastraCompendioView {
    
    
    private String nomeCompendio;

    private List<DBFile> listaArquivos;

    @Autowired
    private DBFileStorageService dbFileStorageService;





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
        return this.dbFileStorageService.getAllFile();
    }

    /**
     * @param listaArquivos the listaArquivos to set
     */
    public void setListaArquivos(List<DBFile> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }
}