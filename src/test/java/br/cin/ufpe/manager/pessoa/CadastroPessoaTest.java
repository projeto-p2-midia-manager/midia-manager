package br.cin.ufpe.manager.pessoa;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.cin.ufpe.manager.cadastro.CadastroPessoa;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.entity.Usuario;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;

/***
 * 
 * @author Fagner Fernandes
 * Classe responsavel por testar a classe ControladorPessoa
 */

@RunWith(value=JUnit4.class)
public class CadastroPessoaTest {
	
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
		CadastroPessoa controladorPessoa = new CadastroPessoa(tipo);
		for (int i = 0; i < 10; i++) {
			Usuario u = new Usuario();
			if(!tipo.equals(TipoRepositorio.BD)){
				u.setId(new Long(i+1));
			}
			u.setCpf("123.456.789-"+i+(i+1));
			u.setNome("John "+ (i+1));
			controladorPessoa.inserirNovaPessoa(u);
		}
		
		Usuario usu = (Usuario) controladorPessoa.buscarPessoa(new Long(1));
		usu.setNome("John Macloud");
		controladorPessoa.atualizarPessoa(usu);
		Usuario usuRepo = (Usuario) controladorPessoa.buscarPessoa(usu.getId());
		Assert.assertTrue(usuRepo.getNome().equals(usu.getNome()));
	}
	
	public void testarInsercao(TipoRepositorio tipo){
		CadastroPessoa cp = new CadastroPessoa(tipo);
		for (int i = 0; i < 10; i++) {
			Usuario u = new Usuario();
			if(!tipo.equals(TipoRepositorio.BD)){
				u.setId(new Long(i+1));
			}
			u.setCpf("123.456.789-"+i+(i+1));
			u.setNome("John "+ (i+1));
			cp.inserirNovaPessoa(u);
		}
		
		Usuario usu = (Usuario) cp.buscarPessoa(new Long(1));
		Assert.assertNotNull(usu);
	}
	
	public void testarListar(TipoRepositorio tipo){
		CadastroPessoa cp = new CadastroPessoa(TipoRepositorio.LISTA);
		for (int i = 0; i < 10; i++) {
			Usuario u = new Usuario();
			if(!tipo.equals(TipoRepositorio.BD)){
				u.setId(new Long(i+1));
			}
			u.setCpf("123.456.789-"+i+(i+1));
			u.setNome("John "+ (i+1));
			cp.inserirNovaPessoa(u);
		}
		
		List<Pessoa> lista = cp.listar();
		Assert.assertTrue(lista.size()>0);
	}	
	
	public void testarRemocao(TipoRepositorio tipo){
		CadastroPessoa cpes = new CadastroPessoa(tipo);
		for (int i = 0; i < 10; i++) {
			Usuario u = new Usuario();
			if(!tipo.equals(TipoRepositorio.BD)){
				u.setId(new Long(i+1));
			}
			u.setCpf("123.456.789-"+i+(i+1));
			u.setNome("John "+ (i+1));
			cpes.inserirNovaPessoa(u);
		}
		
		Usuario usu = (Usuario) cpes.buscarPessoa(new Long(1));
		try {
			cpes.removerPessoa(usu);
		} catch (PessoaNaoEncontradaException e) {
			e.printStackTrace();
		}
		usu = (Usuario) cpes.buscarPessoa(new Long(1));
		Assert.assertNull(usu);
	}	

}
