package br.com.aceleragep.listasRestAPI.services;

import java.util.List;

import javax.transaction.Transactional;

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

	public void remover(Long id) {
		itemRepository.delete(this.buscaPeloId(id));
	}

	public ItemEntity alterar(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public List<ItemEntity> listarItensPelaLista(Long idLista) {
		return itemRepository.findAllByListaId(idLista);
	}

	@Transactional
	public void removerTodosItensDaLista(Long idLista) {
		itemRepository.findAllByListaId(idLista).forEach(item ->{
			this.remover(item.getId());
		});
	}
}
