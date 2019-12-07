package com.projetoPI.model;

import org.junit.Test;

public class CategoriaTest {

	@Test(expected = IllegalArgumentException.class)
	public void criaCategoriaNomeVazio() {
		Categoria c = new Categoria(null);
	}

}
