package com.projetoPI.primefaces.documentos;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetoPI.exeption.FileStorageException;
import com.projetoPI.model.Categoria;
import com.projetoPI.model.DBFile;
import com.projetoPI.service.CategoriaStorageService;
import com.projetoPI.service.DBFileStorageService;

@Named
@RequestScoped
public class FileUploadView {

	private List<Categoria> categorias;

	public DBFile dbFile;
	
	@Autowired
	private DBFileStorageService dbFileStorageService;

	@Autowired 
	CategoriaStorageService categoriaStorageService;




	public void upload(FileUploadEvent event) {
        UploadedFile arq = event.getFile();
		if(arq != null) {
        	try {
				Map<String, String>params =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        		String idCategoria = params.get("catGO:category_input");
        		
        		UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        		System.out.println("Usuário: " + principal);
        		
        		dbFileStorageService.storeFile(arq, idCategoria, principal.getUsername());
        		
        		FacesMessage message = new FacesMessage("Succesful", arq.getFileName() + " foi salvo!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
        		
        	}catch (FileStorageException e) {
        		FacesMessage message = new FacesMessage("Failed", arq.getFileName() + " não foi salvo!!");
        		FacesContext.getCurrentInstance().addMessage(null, message);
			}
        	
        }
	
    }

	public List<Categoria> getCategorias() {
		return this.categoriaStorageService.getAllCategorias();
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}