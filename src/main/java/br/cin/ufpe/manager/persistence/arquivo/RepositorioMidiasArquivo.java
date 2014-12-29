package br.cin.ufpe.manager.persistence.arquivo;

import java.util.List;

import br.cin.ufpe.manager.IRepositorio;
import br.cin.ufpe.manager.entity.Midia;

public class RepositorioMidiasArquivo implements IRepositorio<Midia> {

	private final String nomeArquivo = "midias.txt";
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public List<Midia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Midia m) {
		// TODO Auto-generated method stub
		
	}

	public void remover(Midia m) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Midia m) {
		// TODO Auto-generated method stub
		
	}

	public Midia buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
