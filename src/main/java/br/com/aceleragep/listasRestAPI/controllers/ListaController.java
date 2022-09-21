package br.com.aceleragep.listasRestAPI.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.aceleragep.listasRestAPI.configs.ControllerConfig;
import br.com.aceleragep.listasRestAPI.converts.ItemConvert;
import br.com.aceleragep.listasRestAPI.converts.ListaConvert;
import br.com.aceleragep.listasRestAPI.dtos.inputs.ListaInput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ItemOutput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ListaOutput;
import br.com.aceleragep.listasRestAPI.entities.ItemEntity;
import br.com.aceleragep.listasRestAPI.entities.ListaEntity;
import br.com.aceleragep.listasRestAPI.services.ItemService;
import br.com.aceleragep.listasRestAPI.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Lista")
@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/listas")
public class ListaController {

	@Autowired
	private ListaService listaService;

	@Autowired
	private ListaConvert listaConvert;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Criar nova Lista", description = "Criar uma nova Lista")
	public ListaOutput criaLista(@RequestBody @Valid ListaInput listaInput) throws URISyntaxException {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cria(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Alterar Lista", description = "Alterar uma Lista com os novos dados")
	public ListaOutput alteraLista(@Parameter(description = "Id da Lista", example = "1") @PathVariable Long id, @Valid @RequestBody ListaInput listaInput) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		listaConvert.inputToEntity(listaInput);
		ListaEntity listaAlterada = listaService.alterar(listaEntity);
		return listaConvert.entityToOutput(listaAlterada);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca Lista pelo Id", description = "Buscar uma Lista pelo seu Id")
	public ListaOutput buscaListaPorId(@Parameter(description = "Id da Lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		return listaConvert.entityToOutput(listaEntity);
	}

	@GetMapping
	@Operation(summary = "Listar todas as Lista", description = "Listar todas as Listas cadastradas")
	public List<ListaOutput> listarListas() {
		List<ListaEntity> listaTodos = listaService.listarListas();
		return listaConvert.entityToOutput(listaTodos);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary = "Remover Lista pelo Id", description = "Remover uma Lista e seus itens pelo seu Id")
	public void removeLista(@Parameter(description = "Id da Lista", example = "1")@PathVariable Long id) {
		ListaEntity listaEntity = listaService.buscaPeloId(id);
		itemService.removerTodosItensDaLista(id);
		listaService.remover(listaEntity);
	}
	
	@GetMapping("/{idLista}/itens")
	@Operation(summary = "Listar todos os Itens da Lista", description = "Listar todos os Itens cadastrados em uma Lista")
	public List<ItemOutput> listarItens(@PathVariable Long idLista) {
		List<ItemEntity> listaTodosItens = itemService.listarItensPelaLista(idLista);
		return itemConvert.entityToOutput(listaTodosItens);
	}
}
