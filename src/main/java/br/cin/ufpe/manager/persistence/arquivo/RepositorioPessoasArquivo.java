package br.cin.ufpe.manager.persistence.arquivo;

import java.util.List;

import br.cin.ufpe.manager.IRepositorio;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.util.FileHandler;

public class RepositorioPessoasArquivo implements IRepositorio<Pessoa> {

	private final String nomeArquivo = "pessoas.txt";
	private List<Pessoa> pessoas;
	
	public RepositorioPessoasArquivo() {
		FileHandler fh = new FileHandler();
		this.pessoas = fh.carregarDadosPessoa(nomeArquivo);
	}
	
	public List<Pessoa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Pessoa p) {
		// TODO Auto-generated method stub
		
	}

	public void remover(Pessoa p) throws PessoaNaoEncontradaException {
		Pessoa pessoa = buscarPorId(p.getId());
		pessoas.remove(pessoa);
	}

	public void atualizar(Pessoa t) {
		// TODO Auto-generated method stub
		
	}

	public Pessoa buscarPorId(Long id) throws PessoaNaoEncontradaException {
		Pessoa pessoa = pessoas.get(pessoas.indexOf(id));
		if(pessoa==null){
			throw new PessoaNaoEncontradaException(id);	
		}
		return pessoa;
	}

	public List<Pessoa> getPessoas() {
		if(this.pessoas==null){
			this.pessoas = listar();
		}
		return pessoas;
	}

}
