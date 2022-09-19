package br.com.aceleragep.listasRestAPI.controllers;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.listasRestAPI.configs.ControllerConfig;
import br.com.aceleragep.listasRestAPI.converts.ListaConvert;
import br.com.aceleragep.listasRestAPI.dtos.inputs.ListaInput;
import br.com.aceleragep.listasRestAPI.dtos.outputs.ListaOutput;
import br.com.aceleragep.listasRestAPI.entities.ListaEntity;
import br.com.aceleragep.listasRestAPI.services.ListaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/listas")
public class ListaController {

	@Autowired
	private ListaService listaService;

	@Autowired
	private ListaConvert listaConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
		public ListaOutput cria(@RequestBody @Valid ListaInput listaInput) throws URISyntaxException {
		ListaEntity listaEntity = listaConvert.inputToNewEntity(listaInput);
		ListaEntity listaCriada = listaService.cria(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}
}
