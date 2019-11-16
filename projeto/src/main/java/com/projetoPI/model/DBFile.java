package com.projetoPI.model;

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

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Arquivo")
@Table(name = "arquivo")
public class DBFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "file_id")
	private String file_id;

	private String file_name;

	private String file_type;

	@Lob
	@NotNull
	private byte[] data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private Categoria fileCategoria;

	public DBFile() {
		super();
	}

	public DBFile(String fileName, String fileType, @NotNull byte[] data) {
		super();
		this.file_name = fileName;
		this.file_type = fileType;
		this.data = data;
	}

	public DBFile(String fileName, String fileType, @NotNull byte[] data, Categoria fileCategoria) {
		super();
		this.file_name = fileName;
		this.file_type = fileType;
		this.data = data;
		this.fileCategoria = fileCategoria;
	}

	
	
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

	
	

	

}