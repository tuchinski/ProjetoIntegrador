package com.projetoPI.primefaces.setor;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.primefaces.FacesUtil;
import com.projetoPI.service.SetorStorageService;

@Named
@Scope("view")
public class CriaSetorView {

	private String text;
	@Autowired
	private SetorStorageService service;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void salvaSetor() {
//		System.out.println(text);
		
		
		System.out.println(this.text);
		if(this.text.isEmpty()) {
			System.out.println("String vazia");
		}else {
			this.service.storeSetor(text);
			FacesUtil.addMsgInfo("Setor Salvo com Sucesso");
		}
		this.setText("");
		
		
		
	}
}
