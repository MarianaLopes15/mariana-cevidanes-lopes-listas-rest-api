package br.com.aceleragep.listasRestAPI.converts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.listasRestAPI.dtos.inputs.ItemInput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ItemOutput;
import br.com.aceleragep.listasRestAPI.entities.ItemEntity;

@Component
public class ItemConvert {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ItemEntity inputToEntity(@Valid ItemInput itemInput) {
		return modelMapper.map(itemInput, ItemEntity.class);
	}

	public ItemOutput entityToOutput(ItemEntity itemCriada) {
		return modelMapper.map(itemCriada, ItemOutput.class);
	}

	public List<ItemOutput> entityToOutput(List<ItemEntity> listaTodosItens) {
		return listaTodosItens.stream().map(item -> this.entityToOutput(item)).collect(Collectors.toList());
	}

	public void newInputToEntity(ItemEntity itemEntity, @Valid ItemInput itemInput) {
		 modelMapper.map(itemInput, itemEntity);
	}

	

}
