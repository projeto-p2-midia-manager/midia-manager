package br.cin.ufpe.manager.cadastro;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.ItemMidia;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.exception.ItemNaoEncontradoException;
import br.cin.ufpe.manager.persistence.RepositorioManager;
import br.cin.ufpe.manager.persistence.arquivo.RepositorioManagerArquivo;
import br.cin.ufpe.manager.persistence.bd.RepositorioManagerBD;
import br.cin.ufpe.manager.persistence.lista.RepositorioManagerLista;
import br.cin.ufpe.manager.persistence.vetor.RepositorioManagerVetor;
import br.cin.ufpe.manager.util.FabricaTipoRepositorio;

/**
 * Classe de negócio responsável por repassar as operações CRUD para o repositorio adequado 
 * @author Fagner Fernandes
 *
 */
public class CadastroItens {
	private RepositorioManager repositorio;
	
	public CadastroItens(){
		
	}
	
	public CadastroItens(TipoRepositorio tipo){
		carregarRepositorio(tipo);
	}
	
	/**
	 * Cria o repositorio de acordo com seu tipo
	 * @param tipoRepositorio pode ser ARQUIVO, BD, LISTA ou VETOR
	 */
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
	 * Insere um novo ItemMidia no repositorio adequado
	 * @param i, ItemMidia a ser inserido
	 */
	public void inserirNovoItem(ItemMidia i){
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
	
	/**
	 * Insere um novo ItemMidia no repositorio adequado
	 * @param i, ItemMidia a ser atualizado
	 */
	public void atualizarItem(ItemMidia i) {
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
	
	/**
	 * Remove um novo ItemMidia no repositorio adequado
	 * @param i, ItemMidia a ser removido
	 * @throws ItemNaoEncontradoException caso o ItemMidia a ser removido não exista no repositório
	 */
	public void removerItem(ItemMidia i) throws ItemNaoEncontradoException {
		if(repositorio instanceof RepositorioManagerArquivo){
			((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().remover(i);
		} else if(repositorio instanceof RepositorioManagerBD){
			((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().remover(i);
		} else if(repositorio instanceof RepositorioManagerLista){
			((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().remover(i);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().remover(i);
		}				
	}

	/**
	 * Lista os itens ItemMidia existentes no repositorio adequado
	 * @return uma coleção de ItemMidia
	 */
	public List<ItemMidia> listar(){
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().listar();
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().listar();
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().listar();
		} else if(repositorio instanceof RepositorioManagerVetor) {
			ItemMidia[] vetor = ((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().listar();
			List<ItemMidia> lista = new ArrayList<ItemMidia>();
			for (int i = 0; i < vetor.length; i++) {
				lista.add(vetor[i]);
			}
			return lista;
		}
		return null;
	}

	/**
	 * Retorna um ItemMidia no repositorio adequado
	 * @param id, chave do ItemMidia a ser encontrado
	 * @return um objeto do tipo ItemMidia, caso ele exista no repositorio, ou nulo, caso não exista.
	 */
	public ItemMidia buscarItem(Long id) {
		if(repositorio instanceof RepositorioManagerArquivo){
			return ((RepositorioManagerArquivo) this.repositorio).getRepositorioItensArquivo().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerBD){
			return ((RepositorioManagerBD) this.repositorio).getRepositorioItensBD().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerLista){
			return ((RepositorioManagerLista) this.repositorio).getRepositorioItensLista().buscarPorId(id);
		} else if(repositorio instanceof RepositorioManagerVetor) {
			ItemMidia[] vetor = ((RepositorioManagerVetor) this.repositorio).getRepositorioItensVetor().listar();
			for (int i = 0; i < vetor.length; i++) {
				if(vetor[i]!=null && vetor[i].getId().equals(id)){
					return vetor[i];
				}
			}
		}
		return null;
	}

}
