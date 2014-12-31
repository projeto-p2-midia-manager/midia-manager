package br.cin.ufpe.manager.interfaces;


public interface IRepositorioVetor<T> {
	
	public T[] listar();
	public void inserir(T t);
	public void remover(T t) throws Exception;
	public void atualizar(T t);
	public int buscarPorId(Long id) throws Exception;	

}
