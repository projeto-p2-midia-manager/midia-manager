package br.cin.ufpe.manager.persistence.vetor;

import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.interfaces.IRepositorioVetor;

public class RepositorioPessoasVetor implements IRepositorioVetor<Pessoa> {

	private Pessoa[] pessoas = new Pessoa[10];
	private double loadFactor;
	private static int indice = 0;
	
	private void duplicarCapacidade(){
		indice = 0;
		Pessoa[] temp = new Pessoa[pessoas.length*2];
		for (int i = 0; i < pessoas.length; i++) {
			temp[i] = pessoas[i];
			indice = indice+1;
		}
		pessoas = temp;
	}
	
	public Pessoa[] listar(){
		return pessoas;
	}

	public void inserir(Pessoa t) {
		if(loadFactor >= 0.75){
			duplicarCapacidade();
		}
		indice = indice+1;
		loadFactor = indice/pessoas.length;
		pessoas[indice] = t;
	}

	public void remover(Pessoa m) throws PessoaNaoEncontradaException {
		int posicao = buscarPorId(m.getId());
		if(posicao==-1){
			throw new PessoaNaoEncontradaException(m.getId());
		}
		pessoas[posicao] = null;
		reordenarVetor();
	}

	private void reordenarVetor() {
		for (int posAtual = 0; posAtual < indice; posAtual++) {
			if(pessoas[posAtual]==null && posAtual < indice){
				pessoas[posAtual] = pessoas[posAtual+1]; 
			}
		}
		indice=indice-1;
	}

	public void atualizar(Pessoa pessoaAtualizada) {
		int p = buscarPorId(pessoaAtualizada.getId());
		pessoas[p] = pessoaAtualizada;
	}

	public int buscarPorId(Long id) {
		for (int i = 0; i < indice; i++) {
			if(pessoas[i].getId()==id){
				return i;
			}
		}
		return -1;
	}


}
