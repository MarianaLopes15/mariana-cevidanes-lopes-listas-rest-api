package br.com.aceleragep.listasRestAPI.dtos.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaInput {

	@Length(max = 100)
	@NotBlank(message = "Titulo é obrigatório!")
	private String titulo;
}
