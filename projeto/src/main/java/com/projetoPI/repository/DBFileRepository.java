package com.projetoPI.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.DBFile;


@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{

	/**
	 * @return Lista de Documentos aprovados para publicação
	 */
	@Query("SELECT a FROM Arquivo a WHERE a.isPublicado = 1 AND a.isValidado = 1")
//	@Query(value="SELECT * FROM arquivo WHERE arquivo.is_publicado = 1", nativeQuery = true)
	public List<DBFile> getAllDocumentosAprovadosPublicacao();
	
	/**
	 * @return Lista de Documentos esperando Validação
	 */
	@Query("SELECT a FROM Arquivo a WHERE a.isPublicado = 0 AND a.isValidado = 0")
	public List<DBFile> getAllDocumentosParaValidacao();
	
	
	/**
	 * @return Lista de Documentos esperando Validação
	 */
	@Query("SELECT a FROM Arquivo a WHERE a.isPublicado = 0 AND a.isValidado = 1")
	public List<DBFile> getAllDocumentosParaPublicacao();
	
}
