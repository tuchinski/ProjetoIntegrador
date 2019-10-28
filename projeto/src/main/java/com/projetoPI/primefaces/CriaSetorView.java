package com.projetoPI.primefaces;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

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
		this.service.storeSetor(text);
	}
}
