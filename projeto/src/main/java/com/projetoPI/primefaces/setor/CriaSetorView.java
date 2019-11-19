package com.projetoPI.primefaces.setor;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.projetoPI.model.Categoria;
import com.projetoPI.model.Departamento;
import com.projetoPI.primefaces.FacesUtil;
import com.projetoPI.service.CategoriaStorageService;
import com.projetoPI.service.DepartamentoStorageService;
import com.projetoPI.service.SetorStorageService;

@Named
@Scope("view")
public class CriaSetorView {

	private String text;
	

	private Departamento selectedDepto;

	private List<Departamento> departamentos;
	

	
	public List<Departamento> getDepartamentos() {
		return departamentoService.getAllDepartamento();
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@Autowired
	private SetorStorageService service;
	
	@Autowired
	private DepartamentoStorageService departamentoService;

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
			FacesUtil.addMsgInfo("Não é possível criar um Setor sem nome!!!");
		}else {
//			System.out.println("aaaaa" + selectedDepto.getNome_departamento());
			this.service.storeSetor(this.text,this.selectedDepto);
			FacesUtil.addMsgInfo("Setor Salvo com Sucesso");
		}
		this.setText("");
		
		
		
	}

	public Departamento getSelectedDepto() {
		return selectedDepto;
	}

	public void setSelectedDepto(Departamento selectedDepto) {
		this.selectedDepto = selectedDepto;
	}
}
