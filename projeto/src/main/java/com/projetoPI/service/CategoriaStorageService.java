package com.projetoPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Categoria;
import com.projetoPI.repository.CategoriaRepository;

@Service
public class CategoriaStorageService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria storeCategoria(String nomeCategoria) {
		Categoria c = new Categoria(nomeCategoria);
		return categoriaRepository.save(c);
	}
	
	public Categoria getCategoria(String categoriaId) {
		return categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new MyFileNotFoundException("Categoria não encontrada com o ID " + categoriaId ));
	}
	
}
