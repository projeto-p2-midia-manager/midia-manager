package br.cin.ufpe.manager.persistence.vetor;

import br.cin.ufpe.manager.persistence.RepositorioManager;

public class RepositorioManagerVetor extends RepositorioManager {
	
	private RepositorioMidiasVetor repositorioMidiasVetor;
	private RepositorioItensVetor repositorioItensVetor;
	private RepositorioPessoasVetor repositorioPessoasVetor;

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
