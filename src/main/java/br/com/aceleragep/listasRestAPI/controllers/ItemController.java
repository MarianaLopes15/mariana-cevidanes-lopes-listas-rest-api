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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item")
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
	@Operation(summary = "Criar novo Item", description = "Criar um novo Item em uma Lista")
	public ItemOutput criaItem(@RequestBody @Valid ItemInput itemInput) throws URISyntaxException {
		ItemEntity itemEntity = itemConvert.inputToEntity(itemInput);
		converterIdListaParaListas(itemInput, itemEntity);
		ItemEntity itemCriada = itemService.cria(itemEntity);
		return itemConvert.entityToOutput(itemCriada);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Alterar Item", description = "Alterar um Item com os novos dados")
	public ItemOutput alteraItem(@Parameter(description = "Id do Item", example = "1") @PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemConvert.newInputToEntity(itemEntity, itemInput);
		converterIdListaParaListas(itemInput, itemEntity);
		ItemEntity itemAlterada = itemService.alterar(itemEntity);
		return itemConvert.entityToOutput(itemAlterada);
	}

		
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary = "Remover Item pelo Id", description = "Remover um Item pelo seu Id")
	public void removeItem(@Parameter(description = "Id do Item", example = "1") @PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemService.remover(itemEntity);
	}
	
	private void converterIdListaParaListas(ItemInput itemInput, ItemEntity itemEntity) {
		ListaEntity lista = listaService.buscaPeloId(itemInput.getIdLista());
		itemEntity.setLista(lista);
	}
}
