package com.projetoPI.service;

import java.util.List;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.projetoPI.exeption.FileStorageException;
import com.projetoPI.exeption.MyFileNotFoundException;
import com.projetoPI.model.Categoria;
import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.model.Funcionario;
import com.projetoPI.repository.DBFileRepository;

@Service
public class DBFileStorageService {
	@Autowired
	private DBFileRepository dbFileRepository;
	
	@Autowired
	private CategoriaStorageService categoriaStorageService;
	
	@Autowired
	private FuncionarioStorageService funcionarioStorageService;

	public DBFile storeFile(UploadedFile file, String categoria, String idFuncionarioCriador) {
		String fileName = StringUtils.cleanPath(file.getFileName());
		if (fileName.contains(".mp4")) {
			throw new FileStorageException("Sorry! Extensão inválida do arquivo  " + fileName);
		}
		Categoria c = categoriaStorageService.getCategoria(categoria);
		Funcionario f  = funcionarioStorageService.findByLogin(idFuncionarioCriador);

		DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getContents(),c, f); 
		return dbFileRepository.save(dbFile);
	}
	
	public DBFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
	
	public void editaFile(DBFile novoArquivo) {
		dbFileRepository.save(novoArquivo);
	}
	
	public void removeFile(DBFile arquivo) {
		dbFileRepository.deleteById(arquivo.getFile_id());
	}
	
	public void editaMultiplosFiles(List<DBFile> arquivos) {
		for (DBFile dbFile : arquivos) {
			this.editaFile(dbFile);
		}
	}
	
	public List<DBFile> getAllFile() {
		return dbFileRepository.findAll();
	}
	
	public List<DBFile>getAllFileValidado(){
		return dbFileRepository.findByIsValidadoAndIsRejeitado(true, false);
	}
	
	public List<DBFile> getAllFileParaValidacao(){
		return dbFileRepository.findByIsValidadoAndIsRejeitado(false, false);
	}
	
	public List<DBFile> getAllFileParaValidacaoSetor(String nomeSetor){
		return dbFileRepository.getAllDocumentosParaValidacaoComSetor(nomeSetor);
		
	}

	public List<DBFile> getAllFileRejeitado(){
		return dbFileRepository.findByIsRejeitado(true);
	}
	
	public List<DBFile> getAllFileSemCompendio(){
		return dbFileRepository.findByCompendioAndIsValidado(null, true);
	}
	
	public List<DBFile>findByCompendio(Compendio c){
		return dbFileRepository.findByCompendio(c);
	}
	
	public List<DBFile> findAllFileRejeitadoPorFuncionario(String idFuncionario){
		Funcionario f = funcionarioStorageService.findByLogin(idFuncionario);
		return dbFileRepository.findByIsRejeitadoAndCriadoPor(true, f);
	}
}