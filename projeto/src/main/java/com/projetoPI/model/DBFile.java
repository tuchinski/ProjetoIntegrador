package com.projetoPI.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Arquivo")
@Table(name = "arquivo")
public class DBFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "file_id")
	private String file_id;
	
	@NotNull
	private String file_name;

	@NotNull
	private String file_type;
	
	
	//Verifica se o arquivo foi validado pelo superior
	private boolean isValidado;
	
	//Verifica se o arquivo pode ser publicado para todos
	private boolean isPublicado;
	
	//Verifica se o arquivo foi rejeitado da validação ou publicação
	private boolean isRejeitado;
		
	
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	@Lob
	@NotNull
	private byte[] data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	@NotNull
	private Categoria fileCategoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "compendio_id")
	private Compendio compendios;

	
//////CONSTRUTORES//////////////////////////	
	public DBFile() {
		super();
	}

	public DBFile(String fileName, String fileType, @NotNull byte[] data) {
		super();
		this.file_name = fileName;
		this.file_type = fileType;
		this.data = data;
		this.isPublicado = false;
		this.isValidado = false;
		this.isRejeitado = false;
	}

	public DBFile(String fileName, String fileType, @NotNull byte[] data, Categoria fileCategoria) {
		super();
		this.file_name = fileName;
		this.file_type = fileType;
		this.data = data;
		this.fileCategoria = fileCategoria;
		this.isPublicado = false;
		this.isValidado = false;
		this.isRejeitado = false;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////GETTERS E SETTERS//////////////////////////////////////////////////////////////////////////////////
	
	
	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Categoria getFileCategoria() {
		return fileCategoria;
	}

	public void setFileCategoria(Categoria fileCategoria) {
		this.fileCategoria = fileCategoria;
	}
	
	public String getNomeCategoria() {
		return this.fileCategoria.getNomeCategoria();
	}

	public boolean isValidado() {
		return isValidado;
	}

	public void setValidado(boolean isValidado) {
		this.isValidado = isValidado;
	}

	public boolean isPublicado() {
		return isPublicado;
	}

	public void setPublicado(boolean isPublicado) {
		this.isPublicado = isPublicado;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public boolean isRejeitado() {
		return isRejeitado;
	}

	public void setRejeitado(boolean isRejeitado) {
		this.isRejeitado = isRejeitado;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Compendio getCompendios() {
		return compendios;
	}

	public void setCompendios(Compendio compendios) {
		this.compendios = compendios;
	}

	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
}