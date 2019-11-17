package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Categoria;
import com.projetoPI.model.Departamento;
import com.projetoPI.repository.DepartamentoRepository;

@Service
public class DepartamentoStorageService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Departamento storeDepartamento(String nomeDepto) {
		Departamento d = new Departamento(nomeDepto);
		return departamentoRepository.save(d);
	}
	
	public Departamento getDepartamento(Long deptoId) {
		return departamentoRepository.findById(deptoId)
				.orElseThrow(() -> new MyFileNotFoundException("Departamento não encontrado"));
	}
	
	public List<Departamento> getAllDepartamento(){
		return departamentoRepository.findAll();
	}
	
	public Departamento editaDepartamento(Departamento novoDepto) {
		return departamentoRepository.save(novoDepto);
	}

	public void removeDepartamento(Departamento deleteDepto) {
		departamentoRepository.delete(deleteDepto);
	}
	
	public void removeDepartamentoPorId(Long id) {
		departamentoRepository.deleteById(id);
	}
	
}
