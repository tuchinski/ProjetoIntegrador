package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Categoria;
import com.projetoPI.model.Setor;
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
				.orElseThrow(() -> new MyFileNotFoundException("Categoria não encontrada com o ID " + categoriaId));
	}

	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}
	
	/*
	 * Edita a categoria, recebida por parâmetro
	 * @param Categoria novaCategoria
	 */
	public Categoria editaCategoria(Categoria novaCategoria) {
		return categoriaRepository.save(novaCategoria);
	}

	/*
	 * Deleta a categoria, recebendo como parâmetro, um objeto Categoria
	 * @param Categoria deleteCategoria
	 */
	public void removeCategoria(Categoria deleteCategoria) {
		categoriaRepository.delete(deleteCategoria);
	}
	
	public void removeCategoriaPorId(String id) {
		categoriaRepository.deleteById(id);
	}

}
