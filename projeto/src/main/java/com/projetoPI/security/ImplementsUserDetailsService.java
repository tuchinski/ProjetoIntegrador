package com.projetoPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.Usuario;
import com.projetoPI.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = ur.findByLogin(login);
		
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");			
		}		
		return usuario;
	}

}
