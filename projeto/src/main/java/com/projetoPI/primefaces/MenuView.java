package com.projetoPI.primefaces;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetoPI.service.FuncionarioStorageService;

@ManagedBean
@ViewScoped
public class MenuView {
	String username;
	
	@Autowired
	FuncionarioStorageService funcionarioStorageService;

	public String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String chave = ((UserDetails)principal).getUsername();
			return funcionarioStorageService.findByLogin(chave).getNomeFuncionario();
		}else {
			return principal.toString();
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
