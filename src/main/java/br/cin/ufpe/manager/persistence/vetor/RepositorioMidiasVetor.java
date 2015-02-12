package br.cin.ufpe.manager.persistence.vetor;

import br.cin.ufpe.manager.entity.Midia;
import br.cin.ufpe.manager.exception.MidiaNaoEncontradaException;
import br.cin.ufpe.manager.interfaces.IRepositorioVetor;

/**
 * Classe responsavel pelas operacoes de CRUD da classe Midia usando vetor como repositorio
 * @author Fagner Fernandes
 *
 */
public class RepositorioMidiasVetor implements IRepositorioVetor<Midia> {
	
	private Midia[] midias = new Midia[10];
	private double loadFactor;
	private int indice;
	
	/***
	 * Duplica o tamanho do vetor de Midia quando o mesmo ultrapassa o fator de carga de 75% 
	 */
	private void duplicarCapacidade(){
		this.indice = 0;
		Midia[] temp = new Midia[midias.length*2];
		for (int i = 0; i < midias.length; i++) {
			temp[i] = midias[i];
			indice = indice+1;
		}
		midias = temp;
	}
	
	/**
	 * Retorna a lista de Midias
	 */
	public Midia[] listar(){
		return midias;
	}

	/**
	 * Insere uma nova midia
	 */
	public void inserir(Midia t) {
		if(loadFactor >= 0.75){
			duplicarCapacidade();
		}
		midias[indice] = t;		
		this.indice = this.indice+1;
		loadFactor = (double) indice/midias.length;
	}

	/***
	 * Remove uma midia cadastrada 
	 */
	public void remover(Midia m) throws MidiaNaoEncontradaException {
		int posicao = buscarPorId(m.getId());
		if(posicao==-1){
			throw new MidiaNaoEncontradaException(m.getId());
		}
		midias[posicao] = null;
		reordenarVetor();
	}

	/**
	 * Reordena o vetor para que a busca sequencial seja otimizada
	 */
	private void reordenarVetor() {
		for (int posAtual = 0; posAtual < indice; posAtual++) {
			if(midias[posAtual]==null && posAtual < indice){
				midias[posAtual] = midias[posAtual+1]; 
			}
		}
		indice=indice-1;
	}

	/**
	 * Atualiza uma midia existente
	 */
	public void atualizar(Midia midiaAtualizada) {
		int p = buscarPorId(midiaAtualizada.getId());
		midias[p] = midiaAtualizada;
	}

	/**
	 * Busca uma midia pelo id
	 */
	public int buscarPorId(Long id) {
		for (int i = 0; i < indice; i++) {
			if(midias[i].getId().equals(id)){
				return i;
			}
		}
		return -1;
	}

}
