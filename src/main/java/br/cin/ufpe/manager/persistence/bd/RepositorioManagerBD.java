package br.cin.ufpe.manager.persistence.bd;

import br.cin.ufpe.manager.persistence.RepositorioManager;

public class RepositorioManagerBD extends RepositorioManager {

	private RepositorioMidiasBD repositorioMidiasBD = new RepositorioMidiasBD();
	private RepositorioPessoasBD repositorioPessoasBD = new RepositorioPessoasBD();
	private RepositorioItensBD repositorioItensBD = new RepositorioItensBD();
	
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
