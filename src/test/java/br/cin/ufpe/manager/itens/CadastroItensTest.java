package br.cin.ufpe.manager.itens;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.cin.ufpe.manager.cadastro.CadastroItens;
import br.cin.ufpe.manager.entity.ItemMidia;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.exception.ItemNaoEncontradoException;

/***
 * 
 * @author Fagner Fernandes
 * Classe responsavel por testar a classe ControladorItens
 */
public class CadastroItensTest {

	@Test
	public void testarCadastros(){
		for(TipoRepositorio tipo : TipoRepositorio.values()){
			testarAtualizacao(tipo);
			testarInsercao(tipo);
			testarListar(tipo);
			testarRemocao(tipo);
		}
	}
	
	public void testarAtualizacao(TipoRepositorio tipo){
		CadastroItens controladorItens = new CadastroItens(tipo);
		for (int i = 0; i < 10; i++) {
			ItemMidia item = new ItemMidia();
			item.setId(new Long(i+1));
			item.setDescricao("Big Bang Theory S"+(i+1)+"E"+(i+1));
			controladorItens.inserirNovoItem(item);
		}
		
		ItemMidia midia = (ItemMidia) controladorItens.buscarItem(new Long(1));
		midia.setDescricao("Big Bang Theory S01E01");
		controladorItens.atualizarItem(midia);
		ItemMidia usuRepo = (ItemMidia) controladorItens.buscarItem(midia.getId());
		Assert.assertTrue(usuRepo.getDescricao().equals(midia.getDescricao()));
	}
	
	public void testarInsercao(TipoRepositorio tipo){
		CadastroItens cm = new CadastroItens(tipo);
		for (int i = 0; i < 10; i++) {
			ItemMidia item = new ItemMidia();
			item.setId(new Long(i+1));
			item.setDescricao("Breaking Bad S01E"+ (i+1));
			cm.inserirNovoItem(item);
		}
		
		ItemMidia usu = (ItemMidia) cm.buscarItem(new Long(1));
		Assert.assertNotNull(usu);
	}
	
	public void testarListar(TipoRepositorio tipo){
		CadastroItens cm = new CadastroItens(tipo);
		for (int i = 0; i < 10; i++) {
			ItemMidia item = new ItemMidia();
			item.setId(new Long(i+1));
			item.setDescricao("Backup "+ (i+1));
			cm.inserirNovoItem(item);
		}
		
		List<ItemMidia> lista = cm.listar();
		Assert.assertTrue(lista.size()>0);
	}	
	
	public void testarRemocao(TipoRepositorio tipo){
		CadastroItens cItens = new CadastroItens(tipo);
		for (int i = 0; i < 10; i++) {
			ItemMidia item = new ItemMidia();
			item.setId(new Long(i+1));
			item.setDescricao("Item Backup "+ (i+1));
			cItens.inserirNovoItem(item);
		}
		
		ItemMidia item = (ItemMidia) cItens.buscarItem(new Long(1));
		try {
			cItens.removerItem(item);
		} catch (ItemNaoEncontradoException e) {
			e.printStackTrace();
		}
		item = (ItemMidia) cItens.buscarItem(new Long(1));
		Assert.assertNull(item);
	}	

}
