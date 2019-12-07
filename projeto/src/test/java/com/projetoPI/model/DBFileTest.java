package com.projetoPI.model;

import org.junit.Test;

public class DBFileTest {

	@Test(expected = IllegalArgumentException.class)
	public void subirArquivoComNomeNull() {
		byte[] dados = null;
		DBFile arquivo = new DBFile(null, "teste", dados);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void subirArquivoSemCategoria(){
		Funcionario f =  new Funcionario();
		DBFile arquivo = new DBFile("Teste", "pdf", null, null, f);
	}
}
