package br.com.aceleragep.listasRestAPI.dtos.outputs;

import br.com.aceleragep.listasRestAPI.entities.ListaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	private String titulo;
	private ListaEntity lista;
	private Boolean concluido;
}
