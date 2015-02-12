package br.cin.ufpe.manager.persistence.bd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.cin.ufpe.manager.persistence.RepositorioManager;

/**
 * Classe responsavel por agrupar os repositorios que manipulam as classes b�sicas utilizando Hibernate
 * @author Fagner Fernandes
 *
 */
public class RepositorioManagerBD extends RepositorioManager {
	
	private static final Logger log = LoggerFactory.getLogger(RepositorioManagerBD.class); 

	private RepositorioMidiasBD repositorioMidiasBD;
	private RepositorioPessoasBD repositorioPessoasBD;
	private RepositorioItensBD repositorioItensBD;
	
	public RepositorioManagerBD(){
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream("config.properties");
			prop.load(is);
			String pu = prop.getProperty("activePU");
			this.repositorioItensBD = new RepositorioItensBD(pu);
			this.repositorioMidiasBD = new RepositorioMidiasBD(pu);
			this.repositorioPessoasBD = new RepositorioPessoasBD(pu);
		} catch (IOException e) {
			log.error("Erro ao carregar a unidade de persist�ncia ativa");
		}
		
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
