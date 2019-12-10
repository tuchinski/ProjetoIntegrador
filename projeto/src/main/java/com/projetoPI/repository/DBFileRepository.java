package com.projetoPI.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.Compendio;
import com.projetoPI.model.DBFile;
import com.projetoPI.model.Funcionario;


@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{


	/**
	 * 
	 * @param publicado Verifica se o arquivo foi publicado ou não
	 * @param validado Verifica se o arquivo foi validado ou não
	 * @param rejeitado Verifica se o arquivo foi rejeitado ou não
	 * @return Lista dos arquivos de acordo com os parâmetros passados
	 */
	public List<DBFile> findByIsValidadoAndIsRejeitado(boolean publicado, boolean rejeitado);
	
	
//	exemplo de busca no banco usando query
	/**
	 * @return Lista de docs do mesmo setor passado por parâmetro
	 */
	@Query("SELECT a FROM Arquivo a, Funcionario f WHERE a.criadoPor = f.CPF AND f.setor = ?1 AND a.isRejeitado = false")
	public List<DBFile> getAllDocumentosParaValidacaoComSetor(String nomeSetor);
	
	/**
	 * @return Lista dos Documentos rejeitados
	 */
	public List<DBFile> findByIsRejeitado(boolean isRejeitado);
	
	public List<DBFile> findByCompendio(Compendio c);
	
	public List<DBFile> findByCompendioAndIsValidado(Compendio c, boolean validado);
	
	public List<DBFile> findByIsRejeitadoAndCriadoPor(boolean rejeitado,Funcionario f );
}
