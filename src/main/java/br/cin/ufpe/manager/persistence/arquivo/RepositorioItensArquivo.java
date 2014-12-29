package br.cin.ufpe.manager.persistence.arquivo;

import java.util.List;

import br.cin.ufpe.manager.IRepositorio;
import br.cin.ufpe.manager.entity.ItemBackup;
import br.cin.ufpe.manager.util.FileHandler;

public class RepositorioItensArquivo implements IRepositorio<ItemBackup> {
	
	private final String nomeArquivo = "itens.txt";
	private List<ItemBackup> itens;
	
	public RepositorioItensArquivo(){
		FileHandler fh = new FileHandler();
		this.setItens(fh.carregarDadosItens(nomeArquivo));
	}

	public List<ItemBackup> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(ItemBackup t) {
		// TODO Auto-generated method stub
		
	}

	public void remover(ItemBackup t) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(ItemBackup t) {
		// TODO Auto-generated method stub
		
	}

	public ItemBackup buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ItemBackup> getItens() {
		return itens;
	}

	public void setItens(List<ItemBackup> itens) {
		this.itens = itens;
	}

}
