package com.projetoPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
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
	
	public Setor buscaSetorPorId(long idSetor){
		return repository.findById(Long.toString(idSetor))
				.orElseThrow(() -> new MyFileNotFoundException("Setor com o id " + Long.toString(idSetor)  + " não encontrado"));
	}
	
	public Setor editSetor(Setor novoSetor){
		return repository.save(novoSetor);
	}
	
	/*
	 * Deleta o setor, recebendo como parâmetro, um objeto Setor
	 * @param Setor setorRemovido
	 */
	
	public void deleteSetor(Setor deletedSetor) {
		repository.delete(deletedSetor);
	}
	
	/*
	 * Deleta o setor, recebendo como parâmetro, o ID do setor a ser removido
	 * @param Long idSetor
	 */
	public void deleteSetorPorId(Long idSetor) {
		repository.deleteById(Long.toString(idSetor));
	}
}
