package br.com.aceleragep.listasRestAPI.dtos.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaInput {

	@Length(message = "O Título deve ter no máximo 100 caracteres!", min = 1, max = 100)
	@NotBlank(message = "Titulo é obrigatório!")
	private String titulo;
}
