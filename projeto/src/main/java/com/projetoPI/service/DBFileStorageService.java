package com.projetoPI.service;

import java.util.List;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.projetoPI.exeption.FileStorageException;
import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Categoria;
import com.projetoPI.model.DBFile;
import com.projetoPI.repository.CategoriaRepository;
import com.projetoPI.repository.DBFileRepository;

@Service
public class DBFileStorageService {
	@Autowired
	private DBFileRepository dbFileRepository;
	
	@Autowired
	private CategoriaStorageService categoriaStorageService;

	public DBFile storeFile(UploadedFile file, String categoria) {
		String fileName = StringUtils.cleanPath(file.getFileName());
		if (fileName.contains(".mp4")) {
			throw new FileStorageException("Sorry! Extensão inválida do arquivo  " + fileName);
		}
		Categoria c = categoriaStorageService.getCategoria(categoria);

		DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getContents(),c);
		return dbFileRepository.save(dbFile);
	}
	
	public DBFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
	
	public List<DBFile> getAllFile() {
		return dbFileRepository.findAll();

	}

}