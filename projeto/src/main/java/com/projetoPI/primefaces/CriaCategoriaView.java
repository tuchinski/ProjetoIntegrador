package com.projetoPI.primefaces;

import java.util.Map;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.service.CategoriaStorageService;

//@Named
//@Scope("view")
@ManagedBean
public class CriaCategoriaView {
	
	private String text ;
	
	@Autowired
	private CategoriaStorageService categoriaStorageService;

	
	
	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public void salvaCategoria() {
		System.out.println(this.text);
		if(this.text.isEmpty()) {
			System.out.println("String vazia");
		}else {
			categoriaStorageService.storeCategoria(text);
		}
		this.setText("");
	}
	
}
