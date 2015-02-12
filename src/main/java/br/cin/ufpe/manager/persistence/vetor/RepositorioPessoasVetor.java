package br.cin.ufpe.manager.persistence.vetor;

import java.util.List;

import br.cin.ufpe.manager.entity.Administrador;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.interfaces.IRepositorioVetor;

/**
 * Classe responsavel pelas operacoes de CRUD da classe Pessoa usando vetor como repositorio
 * @author Fagner Fernandes
 *
 */
public class RepositorioPessoasVetor implements IRepositorioVetor<Pessoa> {

	private Pessoa[] pessoas = new Pessoa[10];
	private double loadFactor;
	private int indice;
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}	
	
	private void duplicarCapacidade(){
		setIndice(0);
		Pessoa[] temp = new Pessoa[pessoas.length*2];
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i]!=null){
				temp[i] = pessoas[i];
				setIndice(getIndice()+1);
			}
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
		pessoas[getIndice()] = t;
		setIndice(getIndice()+1);
		loadFactor = (double) getIndice()/pessoas.length;
	}

	public void remover(Pessoa m) throws PessoaNaoEncontradaException {
		int posicao = buscarPorId(m.getId());
		if(posicao==-1){
			throw new PessoaNaoEncontradaException(m.getId());
		}
		pessoas[posicao] = null;
		reordenarVetor(posicao);
	}

	private void reordenarVetor(int posRemovida) {
		if(posRemovida!=getIndice()){
			for (int posAtual = posRemovida; posAtual < getIndice(); posAtual++) {
				int proximo = posAtual+1;
				pessoas[posAtual] = pessoas[proximo]; 
			}
		}
		setIndice(getIndice()-1);
	}

	public void atualizar(Pessoa pessoaAtualizada) {
		int p = buscarPorId(pessoaAtualizada.getId());
		pessoas[p] = pessoaAtualizada;
	}

	public int buscarPorId(Long id) {
		for (int i = 0; i < getIndice(); i++) {
			if(pessoas[i].getId().equals(id)){
				return i;
			}
		}
		return -1;
	}

	public List<Administrador> listarAdministradores() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
