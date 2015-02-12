package br.cin.ufpe.manager.persistence.arquivo;

import br.cin.ufpe.manager.persistence.RepositorioManager;

/**
 * Classe responsavel por agrupar os repositorios que manipulam as classes básicas utilizando Arquivo
 * @author Fagner Fernandes
 *
 */
public class RepositorioManagerArquivo extends RepositorioManager {
	
	private RepositorioMidiasArquivo repositorioMidiasArquivo;
	private RepositorioPessoasArquivo repositorioPessoasArquivo;
	private RepositorioItensArquivo repositorioItensArquivo;
	
	public RepositorioManagerArquivo(){
		this.repositorioItensArquivo = new RepositorioItensArquivo();
		this.repositorioMidiasArquivo = new RepositorioMidiasArquivo();
		this.repositorioPessoasArquivo = new RepositorioPessoasArquivo();
	}
	
	public RepositorioMidiasArquivo getRepositorioMidiasArquivo() {
		return repositorioMidiasArquivo;
	}

	public RepositorioPessoasArquivo getRepositorioPessoasArquivo() {
		return repositorioPessoasArquivo;
	}

	public void setRepositorioPessoasArquivo(RepositorioPessoasArquivo repositorioPessoasArquivo) {
		this.repositorioPessoasArquivo = repositorioPessoasArquivo;
	}

	public RepositorioItensArquivo getRepositorioItensArquivo() {
		return repositorioItensArquivo;
	}

}
