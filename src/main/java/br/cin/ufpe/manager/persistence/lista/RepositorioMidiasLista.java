package br.cin.ufpe.manager.persistence.lista;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.Midia;
import br.cin.ufpe.manager.interfaces.IRepositorio;

public class RepositorioMidiasLista implements IRepositorio<Midia> {
	
	private List<Midia> listaDeMidias;
	
	public RepositorioMidiasLista() {
		this.listaDeMidias = new ArrayList<Midia>();
	}
	
	public List<Midia> getListaDeMidias() {
		return listaDeMidias;
	}

	/***
	 * 
	 */
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

}
