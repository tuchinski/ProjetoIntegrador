package com.projetoPI.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.projetoPI.model.Setor;
import com.projetoPI.repository.SetorRepository;

@Component
public class SetorConverter implements Converter<Setor> {

	@Autowired
	SetorRepository setorRepository;
	
	@Override
	public Setor getAsObject(FacesContext context, UIComponent component, String value) {
		return  setorRepository.getOne(value);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Setor value) {
		
		return value.getSetor_id();
	}

}
