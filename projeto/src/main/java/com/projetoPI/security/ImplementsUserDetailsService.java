package com.projetoPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.Funcionario;
import com.projetoPI.service.FuncionarioStorageService;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private FuncionarioStorageService funcionarioStorageService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Funcionario funcionario = funcionarioStorageService.findByLogin(login);
		
		
		if(funcionario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");			
		}		
//		return usuario;
		return new User(funcionario.getUsername(), funcionario.getPassword(), true, true, true, true, funcionario.getAuthorities());
	}

}
