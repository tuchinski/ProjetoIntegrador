package com.projetoPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoPI.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

}
