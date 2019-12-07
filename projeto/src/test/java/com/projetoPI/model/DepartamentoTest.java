package com.projetoPI.model;

import org.junit.Test;

public class DepartamentoTest {


	@Test(expected = IllegalArgumentException.class)
	public void criaDepartamentoNomeVazio() {
		Departamento d = new Departamento(null);
	}

}
