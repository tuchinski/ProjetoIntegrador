package com.projetoPI.primefaces;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.service.DepartamentoStorageService;

@ManagedBean
@ViewScoped
public class CriaDepartamentoView {

	private String text;
	
	@Autowired
	private DepartamentoStorageService departamentoStorageService;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void salvaDepartamento() {
		System.out.println(this.text);
		if(this.text.isEmpty()) {
			System.out.println("String vazia");
		}else {
			departamentoStorageService.storeDepartamento(text);
			FacesUtil.addMsgInfo("Departamento Salvo com Sucesso!");
		}
		this.setText("");
	}
	
}
