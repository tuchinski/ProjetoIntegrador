package com.projetoPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetoPI.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByLogin(String login);

}