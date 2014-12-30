package br.cin.ufpe.manager.persistence.arquivo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.cin.ufpe.manager.entity.ItemBackup;
import br.cin.ufpe.manager.exception.ItemNaoEncontradoException;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.FileHandler;

public class RepositorioItensArquivo implements IRepositorio<ItemBackup> {
	
	private final String nomeArquivo = "itens.txt";
	private FileHandler fh = new FileHandler();
	private List<ItemBackup> itens;
	private static Logger log = LoggerFactory.getLogger(RepositorioPessoasArquivo.class);

	
	public RepositorioItensArquivo(){
		this.itens = fh.carregarDadosItens(nomeArquivo);
	}

	public List<ItemBackup> listar() {
		return this.itens;
	}

	public void inserir(ItemBackup it) {
		this.itens.add(it);
		fh.escreverItensNoArquivo(nomeArquivo, itens);
	}

	public void remover(ItemBackup i) throws ItemNaoEncontradoException {
		ItemBackup item = buscarPorId(i.getId());
		if(item==null){
			throw new ItemNaoEncontradoException(i.getId());
		}
		itens.remove(item);
		fh.escreverItensNoArquivo(nomeArquivo, itens);
	}

	public void atualizar(ItemBackup i) {
		ItemBackup itemAnterior = buscarPorId(i.getId());
		itens.remove(itemAnterior);
		itens.add(i);
		fh.escreverItensNoArquivo(nomeArquivo, itens);		
	}

	public ItemBackup buscarPorId(Long id) {
		for (ItemBackup i : itens) {
			if(i.getId()==id){
				return i;
			}
		}
		log.info("ID " + id + " nao encontrado na lista de itens.");
		return null;
	}

}
