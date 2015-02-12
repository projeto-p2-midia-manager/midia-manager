package br.cin.ufpe.manager.persistence.vetor;

import br.cin.ufpe.manager.entity.ItemMidia;
import br.cin.ufpe.manager.exception.ItemNaoEncontradoException;
import br.cin.ufpe.manager.interfaces.IRepositorioVetor;

/**
 * Classe responsavel pelas operacoes de CRUD da classe ItemMidia usando vetor como repositorio
 * @author Fagner Fernandes
 *
 */
public class RepositorioItensVetor implements IRepositorioVetor<ItemMidia> {

	private ItemMidia[] itens = new ItemMidia[10];
	private double loadFactor;
	private int indice;
	
	private void duplicarCapacidade(){
		this.indice = 0;
		ItemMidia[] temp = new ItemMidia[itens.length*2];
		for (int i = 0; i < itens.length; i++) {
			temp[i] = itens[i];
			indice = indice+1;
		}
		itens = temp;
	}
	
	/**
	 * lista todos os itens de midia cadastrados
	 */
	public ItemMidia[] listar(){
		return itens;
	}

	/**
	 * Insere um novo item de midia no vetor
	 */
	public void inserir(ItemMidia t) {
		if(loadFactor >= 0.75){
			duplicarCapacidade();
		}
		itens[indice] = t;
		this.indice = this.indice+1;
		loadFactor = (double) indice/itens.length;
	}

	/**
	 * remove um item de midia do vetor
	 */
	public void remover(ItemMidia m) throws ItemNaoEncontradoException {
		int posicao = buscarPorId(m.getId());
		if(posicao==-1){
			throw new ItemNaoEncontradoException(m.getId());
		}
		itens[posicao] = null;
		reordenarVetor();
	}

	/**
	 * reordena o vetor de itens de midia
	 */
	private void reordenarVetor() {
		for (int posAtual = 0; posAtual < indice; posAtual++) {
			if(itens[posAtual]==null && posAtual < indice){
				itens[posAtual] = itens[posAtual+1]; 
			}
		}
		indice=indice-1;
	}

	/**
	 * atualiza um item de midia
	 */
	public void atualizar(ItemMidia itemAtualizada) {
		int p = buscarPorId(itemAtualizada.getId());
		itens[p] = itemAtualizada;
	}

	/**
	 * busca um item de midia por id
	 */
	public int buscarPorId(Long id) {
		for (int i = 0; i < indice; i++) {
			if(itens[i].getId().equals(id)){
				return i;
			}
		}
		return -1;
	}

}
