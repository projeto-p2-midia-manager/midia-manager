package br.cin.ufpe.manager.persistence.lista;

import br.cin.ufpe.manager.persistence.RepositorioManager;

public class RepositorioManagerLista extends RepositorioManager {

	private RepositorioMidiasLista repositorioMidiasLista;
	private RepositorioPessoasLista repositorioPessoasLista;
	private RepositorioItensLista repositorioItensLista;
	
	public RepositorioMidiasLista getRepositorioMidiasLista(){
		return repositorioMidiasLista;
	}
	
	public RepositorioPessoasLista getRepositorioPessoasLista() {
		return repositorioPessoasLista;
	}
	
	public RepositorioItensLista getRepositorioItensLista(){
		return repositorioItensLista;
	}

}
