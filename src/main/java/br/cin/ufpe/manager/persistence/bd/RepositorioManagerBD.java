package br.cin.ufpe.manager.persistence.bd;

import br.cin.ufpe.manager.persistence.RepositorioManager;

public class RepositorioManagerBD extends RepositorioManager {

	private RepositorioMidiasBD repositorioMidiasBD;
	private RepositorioPessoasBD repositorioPessoasBD;
	private RepositorioItensBD repositorioItensBD;
	
	public RepositorioManagerBD(){
		this.repositorioItensBD = new RepositorioItensBD();
		this.repositorioMidiasBD = new RepositorioMidiasBD();
		this.repositorioPessoasBD = new RepositorioPessoasBD();
	}
	
	public RepositorioMidiasBD getRepositorioMidiasBD(){
		return this.repositorioMidiasBD;
	}
	
	public RepositorioPessoasBD getRepositorioPessoasBD() {
		return this.repositorioPessoasBD;
	}
	
	public RepositorioItensBD getRepositorioItensBD(){
		return this.repositorioItensBD;
	}
}
