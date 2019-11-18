package com.projetoPI.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetoPI.model.Departamento;
import com.projetoPI.repository.DepartamentoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class DepartamentoConverter implements Converter<Departamento>{

	@Autowired
	DepartamentoRepository departamentoRepository;
		
	@Override
	public Departamento getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if(value.isEmpty()) {
			return null;
		}
		return departamentoRepository.getOne(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Departamento value) {
		// TODO Auto-generated method stub
		return Long.toString(value.getDepartamento_id());
	}

}
