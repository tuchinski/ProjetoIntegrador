package com.projetoPI.primefaces.Funcionario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;


import org.springframework.beans.factory.annotation.Autowired;

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
	private  String telefone;
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







	public void salvaFuncionario() {
//		System.out.println(this.rg);
//		System.out.println(this.cpf);
//		System.out.println(this.nomeFuncionario);
//		System.out.println(this.sexo);
//		System.out.println(this.telefone);
//		System.out.println(this.e_mail);
//		System.out.println(this.endereco);
		System.out.println(this.setor);
//		System.out.println(this.cargo);
//		System.out.println(this.senha);
//		this.setores=this.getSetores();
//		System.out.println(this.setores.get(0).getNomeSetor());
//		Setor setorClass = this.setorStorageService.buscarSetorPorNome(setor);
//		System.out.println(setorClass.getNomeSetor());
		
		if (this.rg.isEmpty() || this.cpf.isEmpty() || this.nomeFuncionario.isEmpty() || this.e_mail.isEmpty()
				|| this.sexo.isEmpty() || this.endereco.isEmpty() || this.telefone.isEmpty()
				|| this.cargo.isEmpty() || this.setor.isEmpty() || this.senha.isEmpty()) {
			System.out.println("String vazia");
		} else {
			funcionarioStorageService.storeFuncionario(rg, cpf, nomeFuncionario, sexo, telefone, e_mail, endereco, setor, cargo, senha);
			FacesUtil.addMsgInfo("Funcionario Salvo com Sucesso");
		}
//		this.setRg("");
//		this.setCpf("");
//		this.setNomeFuncionario("");
//		this.setSexo("");
//		this.setTelefone("");
//		this.setE_mail("");
//		this.setEndereco("");
//		this.setSetor("");
//		this.setCargo("");
//		this.setSenha("");
	}
	
	
	public List<Setor> getSetores()
	{
		return this.setorStorageService.getAllSetores();
	}
	public void setSetores(List<Setor> setores)
	{
		this.setores=setores;
	}

	 
}
