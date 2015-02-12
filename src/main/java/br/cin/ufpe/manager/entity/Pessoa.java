package br.cin.ufpe.manager.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 * Classe de entidade de pessoa
 * @author Fagner Fernandes
 *
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="pes_tipo")
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="pes_nome")
	private String nome;
	
	@Column(name="pes_cpf")
	private String cpf;
	
	@Column(name="pes_celular")
	private String celular;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * recupera o nome da Pessoa
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * modifica o nome da Pessoa
	 * @param nome a ser atribuido a instancia de Pessoa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * recupera o cpf da Pessoa
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * altera o valor de Cpf na instância da classe
	 * @param cpf a ser atribuido a instancia de Pessoa
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * recupera o celular da Pessoa
	 * @return celular
	 */	
	public String getCelular() {
		return celular;
	}

	/**
	 * altera o valor de celular na instância da classe
	 * @param celular a ser atribuido a instancia de Pessoa
	 */	
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
