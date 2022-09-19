package br.com.aceleragep.listasRestAPI.dtos.inputs;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {
	
	@Length(max = 100)
	@NotBlank(message = "O Titulo é obrigatório!")
	private String titulo;
	
	@NotEmpty(message = "A Lista é obrigatória!")
	private List<Long> idLista;
	
	@NotNull(message = "É obrigatório informar se a lista está concluida")
	private Boolean concluido;


}
