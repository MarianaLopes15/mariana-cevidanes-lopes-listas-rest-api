package br.com.aceleragep.listasRestAPI.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_itens")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo", length = 100)
	private String titulo;
	
	@Column(name = "concluido")
	private Boolean concluido;
		
	@JoinColumn(name = "lista_id")
	@ManyToMany
	@JoinTable(name = "tb_itens_listas", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "lista_id"))
	private List<ListaEntity> lista;
	
}
