package com.projetoPI.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetoPI.model.Categoria;
import com.projetoPI.repository.CategoriaRepository;

@Component
public class CategoriaConverter implements Converter<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
		return  categoriaRepository.getOne(value);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Categoria value) {
		
		return value.getId();
	}

}
