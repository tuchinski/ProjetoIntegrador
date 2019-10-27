package com.projetoPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoPI.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {

}
