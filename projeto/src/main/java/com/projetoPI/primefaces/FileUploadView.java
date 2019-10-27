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
        	System.out.println("Entroooo!!!!!");
        	String fileName = StringUtils.cleanPath(arq.getFileName());
        	System.out.println(arq.getSize());
        	try {
//        		FacesContext context = FacesContext.getCurrentInstance();
//        		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
//        		dbFileStorageService.storeFile(this.file);
        		
//        		System.out.print(file.getFileName() + "hello");
        		this.dbFile = new DBFile(fileName, arq.getContentType(), arq.getContents());
        		System.out.println(this.dbFile.getFileName() + "123456");
        		System.out.println(this.dbFile.getFile_id());
        		System.out.println(dbFileStorageService.storeFile(arq));
        		
        		FacesMessage message = new FacesMessage("Succesful", arq.getFileName() + " foi salvo!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
        		
        	}catch (FileStorageException e) {
        		FacesMessage message = new FacesMessage("Failed", arq.getFileName() + " não foi salvo!!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
			}
        	
        }
    }

//	public void handleFileUpload(FileUploadEvent event) {
//		UploadedFile arq = event.getFile();
//		
//		System.out.println(arq.getFileName());
//		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is bla.");
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
}