package br.com.aceleragep.listasRestAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.listasRestAPI.entities.ListaEntity;
import br.com.aceleragep.listasRestAPI.repositories.ListaRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;
	
	public ListaEntity cria(ListaEntity listaEntity) {
		return listaRepository.save(listaEntity);
	}

}
