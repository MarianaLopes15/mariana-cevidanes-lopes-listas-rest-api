package br.com.aceleragep.listasRestAPI.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		OpenAPI openApi = new OpenAPI();

		Info info = new Info();
		info.title("Avaliação 03 – Acelera G&P: Listas Rest API");
		info.version("0.0.1");
		info.description("<div>"
				+ "       	<h2>Descrição:<h2>"
				+ "			<h4>Swagger da Listas Rest API, composta por Listas e itens das listas</h4>"
				+ "		  </div>"
				 );

		openApi.info(info);
		openApi.addTagsItem(new Tag().name("Lista").description("Controller das Listas"));
		openApi.addTagsItem(new Tag().name("Item").description("Controller dos Itens"));
		return openApi;
	}
}

