package br.com.aceleragep.listasRestAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.listasRestAPI.entities.ItemEntity;


@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	List<ItemEntity> findAllByListaId(Long idLista);

}
