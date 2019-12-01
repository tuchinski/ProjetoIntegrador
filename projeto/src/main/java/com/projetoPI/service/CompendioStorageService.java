package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.repository.CompendioRepository;

@Service
public class CompendioStorageService {

	@Autowired
	private CompendioRepository compendioRepository;

	public Compendio storeCompendio(String nome, List<DBFile> arquivos) {
		Compendio c = new Compendio(nome, arquivos);

		return compendioRepository.save(c);
	}

	public Compendio getCompendio(Long id) {
		return this.compendioRepository.findById(id)
				.orElseThrow(() -> new MyFileNotFoundException("Nao achou compendio com o id " + id));
	}
	
	public List<Compendio> getAllCompendio(){
		return this.compendioRepository.findAll();
	}

	public void editaCompendio(Compendio c) {
		compendioRepository.save(c);
	}

	public void removeCompendio(Compendio c) {
		compendioRepository.delete(c);
	}

}
