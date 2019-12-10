package com.projetoPI.primefaces.Funcionario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Funcionario;
import com.projetoPI.model.Setor;
import com.projetoPI.primefaces.FacesUtil;
import com.projetoPI.service.FuncionarioStorageService;
import com.projetoPI.service.SetorStorageService;

//@Named
//@Scope("view")
@ManagedBean
@ViewScoped

public class CadastraFuncionarioView {

	private String rg;
	private String cpf;
	private String nomeFuncionario;
	private String sexo;
	private String telefone;
	@Email
	private String e_mail;
	private String endereco;
	private String setor;
	private String cargo;
	private String senha;

	private List<Setor> setores;

	@Autowired
	private FuncionarioStorageService funcionarioStorageService;

	@Autowired
	private SetorStorageService setorStorageService;

	public void salvaFuncionario() {
		Funcionario f = null;
		try {
			f = funcionarioStorageService.findByLogin(cpf);
			FacesUtil.addMsgInfo("O CPF JÁ ESTÁ CADASTRADO!");
			System.out.println("O CPF JÁ ESTÁ CADASTRADO!");
			return;
		}catch (MyFileNotFoundException e) {
			funcionarioStorageService.storeFuncionario(rg, cpf, nomeFuncionario, sexo, telefone, e_mail, endereco,
					setor, cargo, senha);
			FacesUtil.addMsgInfo("Funcionario Salvo com Sucesso");
		}
		
//		System.out.println(f.getNomeFuncionario());
//		if (f != null) {
//			
//		} else {

		
//		}
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Setor> getSetores() {
		return this.setorStorageService.getAllSetores();
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

}
