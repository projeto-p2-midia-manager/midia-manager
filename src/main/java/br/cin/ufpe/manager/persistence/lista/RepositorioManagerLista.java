package br.cin.ufpe.manager.persistence.lista;

import br.cin.ufpe.manager.persistence.RepositorioManager;

/**
 * Classe responsavel por agrupar os repositorios que manipulam as classes b�sicas utilizando Lista
 * @author Fagner Fernandes
 *
 */
public class RepositorioManagerLista extends RepositorioManager {

	private RepositorioMidiasLista repositorioMidiasLista;
	private RepositorioPessoasLista repositorioPessoasLista;
	private RepositorioItensLista repositorioItensLista;
	
	public RepositorioManagerLista(){
		this.repositorioItensLista = new RepositorioItensLista();
		this.repositorioMidiasLista = new RepositorioMidiasLista();
		this.repositorioPessoasLista = new RepositorioPessoasLista();
	}
	
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
