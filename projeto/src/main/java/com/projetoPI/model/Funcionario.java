package com.projetoPI.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.ManyToOne;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
public class Funcionario implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3695737069009125654L;

	@NotNull
	private String RG;
	
	@Id
	@NotNull
	@Column(unique=true)
	private String CPF;
	
	@NotNull
	private String nomeFuncionario;
	
	@NotNull
	private String sexo;
	
	@NotNull
	private  String telefone;
	
	@NotNull
	private String E_mail;
	
	@NotNull
	private String endereco;
	
	
	private String setor;
	
	private String cargo;
	
	@NotNull
	private String senha;
	
	@NotNull 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "funcionarios_roles", 
				joinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "CPF"),
				inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;
	
//constructor
	public Funcionario() {
		super();
	}
	public Funcionario(String rG, @NotNull String cPF, @NotNull String nomeFuncionario, String sexo, String telefone,
			String e_mail, String endereco, String setor, String cargo, String senha, List<Role> role) {
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
		this.roles = role;
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
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.roles;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.CPF;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	

}