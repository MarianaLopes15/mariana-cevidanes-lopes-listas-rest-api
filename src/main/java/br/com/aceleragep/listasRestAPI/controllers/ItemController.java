package br.com.aceleragep.listasRestAPI.controllers;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.listasRestAPI.configs.ControllerConfig;
import br.com.aceleragep.listasRestAPI.converts.ItemConvert;
import br.com.aceleragep.listasRestAPI.dtos.inputs.ItemInput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ItemOutput;
import br.com.aceleragep.listasRestAPI.entities.ItemEntity;
import br.com.aceleragep.listasRestAPI.entities.ListaEntity;
import br.com.aceleragep.listasRestAPI.services.ItemService;
import br.com.aceleragep.listasRestAPI.services.ListaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/itens")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private ListaService listaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput criaItem(@RequestBody @Valid ItemInput itemInput) throws URISyntaxException {
		ItemEntity itemEntity = itemConvert.inputToEntity(itemInput);
		converterIdListaParaListas(itemInput, itemEntity);
		ItemEntity itemCriada = itemService.cria(itemEntity);
		return itemConvert.entityToOutput(itemCriada);
	}

	@PutMapping("/{id}")
	public ItemOutput alteraItem(@PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemConvert.newInputToEntity(itemEntity, itemInput);
		converterIdListaParaListas(itemInput, itemEntity);
		ItemEntity itemAlterada = itemService.alterar(itemEntity);
		return itemConvert.entityToOutput(itemAlterada);
	}

		
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemService.remover(itemEntity);
	}
	
	private void converterIdListaParaListas(ItemInput itemInput, ItemEntity itemEntity) {
		ListaEntity lista = listaService.buscaPeloId(itemInput.getIdLista());
		itemEntity.setLista(lista);
	}
}
