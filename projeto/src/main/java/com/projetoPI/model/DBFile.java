package com.projetoPI.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="files")
public class DBFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

    private String fileName;

    private String fileType;
    
    private String fileCategory;
    
    @Lob
    private byte[] data;
    
    public DBFile() {
    	
    }

	public DBFile(String fileName, String fileType, byte[] data, String fileCategory) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.fileCategory = fileCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}
    

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	
}
