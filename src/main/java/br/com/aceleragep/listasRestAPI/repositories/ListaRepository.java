package br.com.aceleragep.listasRestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.listasRestAPI.entities.ListaEntity;

@Repository
public interface ListaRepository extends JpaRepository<ListaEntity, Long> {

}
