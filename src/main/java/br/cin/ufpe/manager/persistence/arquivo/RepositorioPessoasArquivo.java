package br.cin.ufpe.manager.persistence.arquivo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.cin.ufpe.manager.entity.Administrador;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.exception.PessoaNaoEncontradaException;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.FileHandler;

public class RepositorioPessoasArquivo implements IRepositorio<Pessoa> {

	private final String nomeArquivo = "pessoas.txt";
	private FileHandler fh = new FileHandler();
	private List<Pessoa> pessoas;
	private static Logger log = LoggerFactory.getLogger(RepositorioPessoasArquivo.class);
	
	public RepositorioPessoasArquivo() {
		this.pessoas = fh.carregarDadosPessoa(nomeArquivo);
	}
	
	public List<Pessoa> listar() {
		return this.pessoas;
	}

	public void inserir(Pessoa p) {
		this.pessoas.add(p);
		fh.escreverPessoasNoArquivo(nomeArquivo, pessoas);
	}

	public void remover(Pessoa p) throws PessoaNaoEncontradaException {
		Pessoa pessoa = buscarPorId(p.getId());
		pessoas.remove(pessoa);
		fh.escreverPessoasNoArquivo(nomeArquivo, pessoas);
	}

	public void atualizar(Pessoa p) {
		Pessoa pessoa = buscarPorId(p.getId());
		pessoas.remove(pessoa);
		pessoas.add(p);
		fh.escreverPessoasNoArquivo(nomeArquivo, pessoas);
	}

	public Pessoa buscarPorId(Long id) {
		for(Pessoa p : pessoas){
			if(p.getId().equals(id)){
				return p;
			}
		}
		log.info("ID " + id + " nao encontrado na lista de pessoas.");
		return null;
	}

	public List<Pessoa> getPessoas() {
		if(this.pessoas==null){
			this.pessoas = listar();
		}
		return pessoas;
	}

	public List<Administrador> listarAdministradores() {
		List<Pessoa> pes = listar();
		List<Administrador> admnistradores = new ArrayList<Administrador>();
		for (Pessoa p : pes) {
			if(p instanceof Administrador){
				admnistradores.add((Administrador) p);
			}
		}
		return admnistradores;
	}

	public List<Pessoa> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
