package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.model.Setor;
import com.projetoPI.repository.SetorRepository;

@Service
public class SetorStorageService {

	@Autowired
	private SetorRepository repository;
	
	public Setor storeSetor(String nomeSetor) {
		if(nomeSetor == null) {
			System.out.println("Nome do setor Nulo");
			return null;
		}else {
			Setor setor = new Setor(nomeSetor);
			return repository.save(setor);
		}
		
	}
	
	public List<Setor> getAllSetores(){
		return repository.findAll();
	}
}
