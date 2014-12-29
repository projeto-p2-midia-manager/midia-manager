package br.cin.ufpe.manager.persistence.vetor;

import java.util.List;

import br.cin.ufpe.manager.IRepositorio;
import br.cin.ufpe.manager.entity.Midia;

public class RepositorioMidiasVetor implements IRepositorio<Midia> {
	
	private Midia[] midias;

	public List<Midia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Midia t) {
		// TODO Auto-generated method stub
		
	}

	public void remover(Midia t) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Midia t) {
		// TODO Auto-generated method stub
		
	}

	public Midia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Midia[] getMidias() {
		return midias;
	}

	public void setMidias(Midia[] midias) {
		this.midias = midias;
	}


}
