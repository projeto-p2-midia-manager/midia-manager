package br.cin.ufpe.manager.persistence.lista;

import java.util.ArrayList;
import java.util.List;

import br.cin.ufpe.manager.entity.Administrador;
import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.interfaces.IRepositorio;

public class RepositorioPessoasLista implements IRepositorio<Pessoa> {

	private List<Pessoa> itens;
	
	public RepositorioPessoasLista(){
		this.itens = new ArrayList<Pessoa>();
	}
	
	public List<Pessoa> listar() {
		return itens;
	}

	public void inserir(Pessoa i) {
		itens.add(i);
	}

	public void remover(Pessoa i) {
		itens.remove(i);
	}

	public void atualizar(Pessoa i) {
		Pessoa pessoaAnterior = buscarPorId(i.getId());
		itens.remove(pessoaAnterior);
		itens.add(i);
	}

	public Pessoa buscarPorId(Long id) {
		for (Pessoa p : itens) {
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}

	public List<Administrador> listarAdministradores() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
