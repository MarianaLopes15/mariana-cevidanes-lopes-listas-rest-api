package br.com.aceleragep.listasRestAPI.dtos.inputs;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {
	
	@Length(message = "O Título deve ter no máximo 100 caracteres!", min = 1, max = 100)
	@NotBlank(message = "O Titulo é obrigatório!")
	private String titulo;
	
	@NotNull(message = "A Lista é obrigatória!")
	private Long idLista;
}
