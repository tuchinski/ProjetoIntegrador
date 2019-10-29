package com.projetoPI.model;

import org.junit.Test;

public class SetorTest {

	@Test(expected = IllegalArgumentException.class)
	public void criaSetorComNomeNull() {
		Setor s = new Setor(null);
	}

}
