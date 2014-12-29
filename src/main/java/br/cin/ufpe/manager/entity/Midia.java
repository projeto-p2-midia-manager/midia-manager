package br.cin.ufpe.manager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Midia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mid_id")
	private Long id;
	
	@Column(name="mid_nome")
	private String nome;
	
	@OneToMany
	private List<ItemBackup> itens; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public List<ItemBackup> getItens() {
		return itens;
	}

	public void setItens(List<ItemBackup> itens) {
		this.itens = itens;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return id + "," + nome;
	}

}
