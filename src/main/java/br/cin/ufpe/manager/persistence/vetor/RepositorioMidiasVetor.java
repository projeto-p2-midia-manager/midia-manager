package br.cin.ufpe.manager.persistence.vetor;

import java.util.List;

import br.cin.ufpe.manager.entity.Midia;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.interfaces.IRepositorioVetor;

public class RepositorioMidiasVetor implements IRepositorioVetor<Midia> {
	
	private Midia[] midias = new Midia[10];
	private double loadFactor;
	private static int pos = 0;
	
	private void duplicarCapacidade(){
		pos = 0;
		Midia[] temp = new Midia[midias.length*2];
		for (int i = 0; i < midias.length; i++) {
			temp[i] = midias[i];
			pos = pos+1;
		}
		midias = temp;
	}
	
	public Midia[] listar(){
		return midias;
	}

	public void inserir(Midia t) {
		if(loadFactor >= 0.75){
			duplicarCapacidade();
		}
		pos = pos+1;
		loadFactor = pos/midias.length;
	}

	public void remover(Midia t) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Midia t) {
		// TODO Auto-generated method stub
		
	}

	public Midia buscarPorId(Long id) {
		return null;
	}

}
