package com.projetoPI.primefaces.Funcionario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.model.Funcionario;
import com.projetoPI.service.FuncionarioStorageService;

@ManagedBean
@ViewScoped
public class BuscarFuncView {

	List<Funcionario> funcionarios;
	
	@Autowired
	private FuncionarioStorageService funcionarioStorageService;

	public List<Funcionario> getFuncionarios() {
		return this.funcionarioStorageService.getAllFuncionario();
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
