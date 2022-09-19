package br.com.aceleragep.listasRestAPI.converts;

import java.util.List;
import java.util.stream.Collectors;

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

	public ListaEntity inputToEntity(@Valid ListaInput listaInput) {
		return modelMapper.map(listaInput, ListaEntity.class);
	}

	public ListaOutput entityToOutput(ListaEntity listaCriada) {
		return modelMapper.map(listaCriada, ListaOutput.class);
	}

	public List<ListaOutput> entityToOutput(List<ListaEntity> listaTodos) {
		return listaTodos.stream().map(lista -> this.entityToOutput(lista)).collect(Collectors.toList());
	}

}
