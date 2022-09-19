package br.com.aceleragep.listasRestAPI.services;

import java.util.List;

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

	public List<ListaEntity> listarListas() {
		return listaRepository.findAll();
	}

	public ListaEntity alterar(ListaEntity listaEntity) {
		return listaRepository.save(listaEntity);
	}

	public ListaEntity buscaPeloId(Long id) {
		return listaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrada a lista pelo id: " + id));
	}

	public void remover(ListaEntity listaEntity) {
		listaRepository.delete(listaEntity);
		
	}

}
