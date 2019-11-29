package com.projetoPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
public class Funcionario {
	@Id
	private String RG;
	
	
	@NotNull
	@Column(unique=true)
	private String CPF;
	
	@NotNull
	private String nomeFuncionario;
	
	private String sexo;
	
	private  String telefone;
	
	private String E_mail;
	
	private String endereco;
	
	
	private String setor;
	
	private String cargo;
	
	private String senha;
//constructor
	public Funcionario() {
		super();
	}
	public Funcionario(String rG, @NotNull String cPF, @NotNull String nomeFuncionario, String sexo, String telefone,
			String e_mail, String endereco, String setor, String cargo, String senha) {
		super();
		this.RG = rG;
		this.CPF = cPF;
		this.nomeFuncionario = nomeFuncionario;
		this.sexo = sexo;
		this.telefone = telefone;
		this.E_mail = e_mail;
		this.endereco = endereco;
		this.setor = setor;
		this.cargo = cargo;
		this.senha = senha;
	}
//getter&setter
	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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
		return E_mail;
	}

	public void setE_mail(String e_mail) {
		E_mail = e_mail;
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
	
	
	
	
	
	
	

}