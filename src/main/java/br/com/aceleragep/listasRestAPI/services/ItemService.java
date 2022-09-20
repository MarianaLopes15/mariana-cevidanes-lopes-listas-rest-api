package br.com.aceleragep.listasRestAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.listasRestAPI.entities.ItemEntity;
import br.com.aceleragep.listasRestAPI.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity cria(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public ItemEntity buscaPeloId(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrada o item pelo id: " + id));
	}

	public void remover(ItemEntity itemEntity) {
		itemRepository.delete(itemEntity);
	}

	public ItemEntity alterar(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public List<ItemEntity> listarItensPelaLista(Long idLista) {
		return itemRepository.findAllByListaId(idLista);
	}

}
