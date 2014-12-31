package br.cin.ufpe.manager.persistence.vetor;

import br.cin.ufpe.manager.persistence.RepositorioManager;

public class RepositorioManagerVetor extends RepositorioManager {
	
	private RepositorioMidiasVetor repositorioMidiasVetor;
	private RepositorioItensVetor repositorioItensVetor;
	private RepositorioPessoasVetor repositorioPessoasVetor;
	
	public RepositorioManagerVetor(){
		this.repositorioItensVetor = new RepositorioItensVetor();
		this.repositorioMidiasVetor = new RepositorioMidiasVetor();
		this.repositorioPessoasVetor = new RepositorioPessoasVetor();
	}	

	public RepositorioItensVetor getRepositorioItensVetor() {
		return repositorioItensVetor;
	}
	
	public RepositorioMidiasVetor getRepositorioMidiasVetor(){
		return repositorioMidiasVetor;
	}
	
	public RepositorioPessoasVetor getRepositorioPessoasVetor(){
		return repositorioPessoasVetor;
	}

}
