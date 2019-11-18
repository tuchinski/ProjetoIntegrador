package com.projetoPI.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.DBFile;


@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{


	/**
	 * 
	 * @param publicado Verifica se o arquivo foi publicado ou não
	 * @param validado Verifica se o arquivo foi validado ou não
	 * @param rejeitado Verifica se o arquivo foi rejeitado ou não
	 * @return Lista dos arquivos de acordo com os parâmetros passados
	 */
	public List<DBFile> findByIsPublicadoAndIsValidadoAndIsRejeitado(boolean publicado, boolean validado, boolean rejeitado);
	
	
//	exemplo de busca no banco usando query
//	/**
//	 * @return Lista de Documentos esperando Validação
//	 */
//	@Query("SELECT a FROM Arquivo a WHERE a.isPublicado = 0 AND a.isValidado = 1")
//	public List<DBFile> getAllDocumentosParaPublicacao();
//	
	/**
	 * @return Lista dos Documentos rejeitados
	 */
	public List<DBFile> findByIsRejeitado(boolean isRejeitado);
}
