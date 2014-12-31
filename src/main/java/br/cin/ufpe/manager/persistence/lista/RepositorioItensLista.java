package br.cin.ufpe.manager.persistence.lista;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.ItemBackup;
import br.cin.ufpe.manager.interfaces.IRepositorio;

public class RepositorioItensLista implements IRepositorio<ItemBackup> {
	
	private List<ItemBackup> itens;
	
	public RepositorioItensLista(){
		this.itens = new ArrayList<ItemBackup>();
	}
	
	public List<ItemBackup> listar() {
		return itens;
	}

	public void inserir(ItemBackup i) {
		itens.add(i);
	}

	public void remover(ItemBackup i) {
		itens.remove(i);
	}

	public void atualizar(ItemBackup i) {
		ItemBackup itemAnterior = buscarPorId(i.getId());
		itens.remove(itemAnterior);
		itens.add(i);
	}

	public ItemBackup buscarPorId(Long id) {
		for (ItemBackup itemBackup : itens) {
			if(itemBackup.getId()==id){
				return itemBackup;
			}
		}
		return null;
	}

}
