package com.projetoPI.primefaces;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.projetoPI.exeption.FileStorageException;
import com.projetoPI.model.DBFile;
import com.projetoPI.service.DBFileStorageService;

@Named
@Scope("view")
public class FileUploadView {

	private UploadedFile file;
	public DBFile dbFile;
	@Autowired
	private DBFileStorageService dbFileStorageService;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload(FileUploadEvent event) {
        UploadedFile arq = event.getFile();
		if(arq != null) {
        	try {
        		dbFileStorageService.storeFile(arq);
        		
        		FacesMessage message = new FacesMessage("Succesful", arq.getFileName() + " foi salvo!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
        		
        	}catch (FileStorageException e) {
        		FacesMessage message = new FacesMessage("Failed", arq.getFileName() + " não foi salvo!!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
			}
        	
        }
    }

}