package com.projetoPI.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompendioTest {

	@Test(expected = IllegalArgumentException.class)
	public void criaCompendioSemNome() {
		DBFile arquivo = new DBFile();
		List<DBFile> arquivos = new ArrayList<>();
		arquivos.add(arquivo);
		Compendio c = new Compendio(null, arquivos);
	}

}
