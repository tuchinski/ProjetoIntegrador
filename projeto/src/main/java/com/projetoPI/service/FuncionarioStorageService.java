package com.projetoPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Funcionario;
import com.projetoPI.model.Role;
import com.projetoPI.repository.FuncionarioRepository;
import com.projetoPI.repository.RoleRepository;


@Service
public class FuncionarioStorageService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private SetorStorageService setorservice;
	
	@Autowired
	private RoleRepository roleRepository;

	public Funcionario storeFuncionario(String rg, String cpf, String nomeFuncionario, String sexo, String telefone, String e_mail, String endereco, 
String setor, String cargo, String senha) {
		//dados
		System.out.print("service");
		System.out.println(rg);
		System.out.println(cpf);
		System.out.println(nomeFuncionario);
		System.out.println(sexo);
		System.out.println(telefone);
		System.out.println(e_mail);
		System.out.println(endereco);
		System.out.println(setor);
		System.out.println(cargo);
		System.out.println(senha);
		
		senha = new BCryptPasswordEncoder().encode(senha);
		List<Role> roles= new ArrayList<>();
		
		roles.add(roleRepository.findById(cargo)
				.orElseThrow(() -> new MyFileNotFoundException("role nao encontrada")));
		
		Funcionario f = new Funcionario(rg, cpf, nomeFuncionario, sexo, telefone, e_mail, endereco, setor, cargo, senha,roles);
		return funcionarioRepository.save(f);
	}

	public Funcionario findByLogin(String id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new MyFileNotFoundException("Não achei o funcionario com o ID " + id));
	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}
	
	/*
	 * Edita a categoria, recebida por parâmetro
	 * @param Categoria novaCategoria
	 */
	public Funcionario editaFuncionario(Funcionario novaFuncionario) {
		return funcionarioRepository.save(novaFuncionario);
	}

	/*
	 * Deleta a categoria, recebendo como parâmetro, um objeto Categoria
	 * @param Categoria deleteCategoria
	 */
	public void removeFuncionario(Funcionario deleteFuncionario) {
		funcionarioRepository.delete(deleteFuncionario);
	}
	
	public void removeFuncionarioPorId(String id) {
		funcionarioRepository.deleteById(id);
	}

}
