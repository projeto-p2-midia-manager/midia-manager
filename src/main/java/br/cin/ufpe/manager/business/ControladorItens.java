package br.cin.ufpe.manager.business;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.ItemBackup;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.exception.ItemNaoEncontradoException;
import br.cin.ufpe.manager.persistence.RepositorioManager;
import br.cin.ufpe.manager.persistence.arquivo.RepositorioManagerArquivo;
import br.cin.ufpe.manager.persistence.bd.RepositorioManagerBD;
import br.cin.ufpe.manager.persistence.lista.RepositorioManagerLista;
import br.cin.ufpe.manager.persistence.vetor.RepositorioManagerVetor;
import br.cin.ufpe.manager.util.FabricaTipoRepositorio;

public class ControladorItens {
	private RepositorioManager repositorio;
	
	public ControladorItens(){
		
	}
	
	public ControladorItens(TipoRepositorio tipo){
		carregarRepositorio(tipo);
	}
	
	private void carregarRepositorio(TipoRepositorio tipoRepositorio) {
		FabricaTipoRepositorio fabrica = new FabricaTipoRepositorio();
		this.setRepositorio(fabrica.getRepositorio(tipoRepositorio));		
	}

	public RepositorioManager getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioManager repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserirNovoItem(ItemBackup i){
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().inserir(i);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().inserir(i);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().inserir(i);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().inserir(i);
		}
	}
	
	public void atualizarMidia(ItemBackup i) {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().atualizar(i);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().atualizar(i);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().atualizar(i);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().atualizar(i);
		}		
	}
	
	public void removerMidia(ItemBackup i) throws ItemNaoEncontradoException {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().remover(i);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().atualizar(i);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().atualizar(i);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().atualizar(i);
		}				
	}

	public List<ItemBackup> listar(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().listar();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().listar();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().listar();
		} else if(repositorio instanceof RepositorioManagerVetor) {
			ItemBackup[] vetor = ((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().listar();
			List<ItemBackup> lista = new ArrayList<ItemBackup>();
			for (int i = 0; i < vetor.length; i++) {
				lista.add(vetor[i]);
			}
			return lista;
		}
		return null;
	}

}
