package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.repository.CompendioRepository;

public class CompendioStorageService {

	@Autowired
	private CompendioRepository compendioRepository;
	
	public Compendio getCompendio(long compendioId) {
		return compendioRepository.findById(compendioId)
				.orElseThrow(() -> new MyFileNotFoundException("Compendio não encontrado com o ID " + compendioId));
	}
	
	public List<Compendio> getAllCompendio(){
		return this.compendioRepository.findAll();
	}
	
	public Compendio storeCompendio(String nome, List<DBFile> arquivos) {
		Compendio c = new Compendio(nome, arquivos);
		
		return compendioRepository.save(c);
	}
	
	public void editaCompendio(Compendio c) {
		compendioRepository.save(c);
	}
	
	public void removeCompendio(Compendio c) {
		compendioRepository.delete(c);
	}
	
}











