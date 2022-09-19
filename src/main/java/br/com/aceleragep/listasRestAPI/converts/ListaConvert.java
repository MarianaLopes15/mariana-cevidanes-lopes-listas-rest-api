package br.com.aceleragep.listasRestAPI.converts;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.listasRestAPI.dtos.inputs.ListaInput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ListaOutput;
import br.com.aceleragep.listasRestAPI.entities.ListaEntity;

@Component
public class ListaConvert {
	
	@Autowired
	private ModelMapper modelMapper;

	public ListaEntity inputToNewEntity(@Valid ListaInput listaInput) {
		return modelMapper.map(listaInput, ListaEntity.class);
	}

	public ListaOutput entityToOutput(ListaEntity listaCriada) {
		return modelMapper.map(listaCriada, ListaOutput.class);
	}

}
