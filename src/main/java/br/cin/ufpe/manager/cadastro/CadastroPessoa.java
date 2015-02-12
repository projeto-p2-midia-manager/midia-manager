package br.cin.ufpe.manager.cadastro;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.Administrador;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.persistence.RepositorioManager;
import br.cin.ufpe.manager.persistence.arquivo.RepositorioManagerArquivo;
import br.cin.ufpe.manager.persistence.bd.RepositorioManagerBD;
import br.cin.ufpe.manager.persistence.lista.RepositorioManagerLista;
import br.cin.ufpe.manager.persistence.vetor.RepositorioManagerVetor;
import br.cin.ufpe.manager.util.FabricaTipoRepositorio;

/***
 * 
 * @author Fagner Fernandes
 * Classe de negocio responsavel por manipular as operacoes de CRUD da classe Pessoa
 *
 */
public class CadastroPessoa {
	
	private RepositorioManager repositorio;
	
	public CadastroPessoa(){
		
	}
	
	public CadastroPessoa(TipoRepositorio tipo){
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
	
	/**
	 * Atualiza uma nova Pessoa no repositorio adequado
	 * @param p, Pessoa a ser atualizada
	 */	
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

	/**
	 * Retorna uma Pessoa no repositorio adequado
	 * @param id, chave da Pessoa a ser encontrada
	 * @return um objeto do tipo Pessoa, caso ele exista no repositorio, ou nulo, caso não exista.
	 */
	public Pessoa buscarPessoa(Long id){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			Pessoa[] vetor = ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().listar();
			int indice = ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().getIndice();
			for (int i = 0; i < indice; i++) {
				if(vetor[i].getId().equals(id)){
					return vetor[i];
				}
			}
		}
		return null;		
	}
	
	/**
	 * Insere uma nova Pessoa no repositorio adequado
	 * @param p, Pessoa a ser inserida
	 */	
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
	
	/**
	 * Lista os itens Pessoa existentes no repositorio adequado
	 * @return uma coleção de Pessoa
	 */
	public List<Pessoa> listar(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().listar();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().listar();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().listar();
		} else if(repositorio instanceof RepositorioManagerVetor) {
			Pessoa[] vetor = ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().listar();
			List<Pessoa> lista = new ArrayList<Pessoa>();
			for (int i = 0; i < vetor.length; i++) {
				lista.add(vetor[i]);
			}
			return lista;
		}
		return null;
	}
	
	/**
	 * Remove uma Pessoa no repositorio adequado
	 * @param p, Pessoa a ser removida
	 * @throws PessoaNaoEncontradaException caso a pessoa nao exista no repositorio
	 */
	public void removerPessoa(Pessoa p) throws PessoaNaoEncontradaException {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().remover(p);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().remover(p);;
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().remover(p);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().remover(p);
		}				
	}
	
	/**
	 * Lista uma coleção de Usuarios cadastrados no repositorio adequado
	 * @return coleção de usuarios
	 */	
	public List<Pessoa> listarUsuarios(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().listarUsuarios();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().listarUsuarios();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().listarUsuarios();
		} else {
			return ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().listarUsuarios();
		}				
	}

	/**
	 * Lista uma coleção de Administradores cadastrados no repositorio adequado
	 * @return coleção de administradores
	 */	
	public List<Administrador> listarAdministradores(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioPessoasArquivo().listarAdministradores();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioPessoasBD().listarAdministradores();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioPessoasLista().listarAdministradores();
		} else {
			return ((RepositorioManagerVetor) this.repositorio).getRepositorioPessoasVetor().listarAdministradores();
		}				
		
	}

}
