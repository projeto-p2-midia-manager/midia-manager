package br.cin.ufpe.manager.interfaces;

import java.util.List;

public interface IRepositorio<T> {
	
	public List<T> listar();
	public void inserir(T t);
	public void remover(T t) throws Exception;
	public void atualizar(T t);
	public T buscarPorId(Long id) throws Exception;

}
