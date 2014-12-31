package br.cin.ufpe.manager.util;

import java.util.HashMap;
import java.util.Map;

import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.persistence.RepositorioManager;
import br.cin.ufpe.manager.persistence.arquivo.RepositorioManagerArquivo;
import br.cin.ufpe.manager.persistence.bd.RepositorioManagerBD;
import br.cin.ufpe.manager.persistence.lista.RepositorioManagerLista;
import br.cin.ufpe.manager.persistence.vetor.RepositorioManagerVetor;

public class FabricaTipoRepositorio {
	
	private Map<TipoRepositorio, RepositorioManager> mapasRepo;
	
	public FabricaTipoRepositorio(){
		this.mapasRepo = new HashMap<TipoRepositorio, RepositorioManager>();
		this.mapasRepo.put(TipoRepositorio.ARQUIVO, new RepositorioManagerArquivo());
		this.mapasRepo.put(TipoRepositorio.BD, new RepositorioManagerBD());
		this.mapasRepo.put(TipoRepositorio.LISTA, new RepositorioManagerLista());
		this.mapasRepo.put(TipoRepositorio.VETOR, new RepositorioManagerVetor());
	}
	
	public RepositorioManager getRepositorio(TipoRepositorio tipoRepositorio) {
		return mapasRepo.get(tipoRepositorio);
	}

}
