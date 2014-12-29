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
	
	private static Map<TipoRepositorio, RepositorioManager> mapasRepo = new HashMap<TipoRepositorio, RepositorioManager>();
	
	public FabricaTipoRepositorio(){
		mapasRepo.put(TipoRepositorio.ARQUIVO, new RepositorioManagerArquivo());
		mapasRepo.put(TipoRepositorio.BD, new RepositorioManagerBD());
		mapasRepo.put(TipoRepositorio.LISTA, new RepositorioManagerLista());
		mapasRepo.put(TipoRepositorio.VETOR, new RepositorioManagerVetor());
	}
	
	public static RepositorioManager getRepositorio(TipoRepositorio tipoRepositorio) {
		return mapasRepo.get(tipoRepositorio);
	}

}
