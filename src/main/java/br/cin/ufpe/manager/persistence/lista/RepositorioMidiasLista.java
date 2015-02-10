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

	public List<Midia> listar() {
		return this.listaDeMidias;
	}

	public void inserir(Midia m) {
		this.listaDeMidias.add(m);
	}

	public void remover(Midia m) {
		this.listaDeMidias.remove(m);
	}

	public void atualizar(Midia m) {
		Midia midiaAnterior = buscarPorId(m.getId());
		this.listaDeMidias.remove(midiaAnterior);
		this.listaDeMidias.add(m);
	}

	public Midia buscarPorId(Long id) {
		for (Midia midia : listaDeMidias) {
			if(midia.getId().equals(id)){
				return midia;
			}
		}
		return null;
	}

}
