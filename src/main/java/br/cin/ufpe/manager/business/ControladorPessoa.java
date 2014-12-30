package br.cin.ufpe.manager.business;

import java.util.List;

import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.persistence.RepositorioManager;
import br.cin.ufpe.manager.persistence.arquivo.RepositorioManagerArquivo;
import br.cin.ufpe.manager.persistence.bd.RepositorioManagerBD;
import br.cin.ufpe.manager.persistence.lista.RepositorioManagerLista;
import br.cin.ufpe.manager.persistence.vetor.RepositorioManagerVetor;
import br.cin.ufpe.manager.util.FabricaTipoRepositorio;

public class ControladorPessoa {
	
	private RepositorioManager repositorio;
	
	public ControladorPessoa(){
		
	}
	
	public ControladorPessoa(TipoRepositorio tipo){
		carregarRepositorio(tipo);
	}
	
	private void carregarRepositorio(TipoRepositorio tipoRepositorio) {
		this.setRepositorio(FabricaTipoRepositorio.getRepositorio(tipoRepositorio));		
	}

	public RepositorioManager getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioManager repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserirNovaPessoa(Pessoa p){
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().inserir(p);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().inserir(p);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().inserir(p);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().inserir(p);
		}
	}
	
	public void atualizarPessoa(Pessoa p) {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().atualizar(p);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().atualizar(p);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().atualizar(p);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().atualizar(p);
		}		
	}
	
	public void removerPessoa(Pessoa p) throws PessoaNaoEncontradaException {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().remover(p);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().atualizar(p);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().atualizar(p);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().atualizar(p);
		}				
	}

	public List<Pessoa> listar(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().listar();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().listar();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().listar();
		} else if(repositorio instanceof RepositorioManagerVetor) {
			return ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().listar();
		}
		return null;
	}

}
