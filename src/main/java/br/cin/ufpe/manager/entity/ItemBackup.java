package br.cin.ufpe.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemBackup {

	@Id
	@GeneratedValue
	@Column(name="itm_codigo")
	private Long id;
	
	@Column(name="itm_descricao")
	private String descrição;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	@Override
	public String toString() {
		return id + "," + descrição;
	}
}
