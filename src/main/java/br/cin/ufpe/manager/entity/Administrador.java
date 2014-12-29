package br.cin.ufpe.manager.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADM")
public class Administrador extends Pessoa {
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return getId() + "," + getNome() + "," + getCpf() + "," + this.email + ",ADM";
	}

}
