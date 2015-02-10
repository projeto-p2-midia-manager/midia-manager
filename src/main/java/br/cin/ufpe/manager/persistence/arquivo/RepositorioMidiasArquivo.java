package br.cin.ufpe.manager.persistence.arquivo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.cin.ufpe.manager.entity.Midia;
import br.cin.ufpe.manager.exception.MidiaNaoEncontradaException;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.FileHandler;

public class RepositorioMidiasArquivo implements IRepositorio<Midia> {

	private final String nomeArquivo = "midias.txt";
	private FileHandler fh = new FileHandler();
	private List<Midia> midias;
	private static Logger log = LoggerFactory.getLogger(RepositorioPessoasArquivo.class);
	
	public RepositorioMidiasArquivo(){
		midias = fh.carregarDadosMidia(nomeArquivo);
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public List<Midia> listar() {
		return this.midias;
	}

	public void inserir(Midia m) {
		midias.add(m);
		fh.escreverMidiasNoArquivo(nomeArquivo, midias);
	}

	public void remover(Midia m) throws MidiaNaoEncontradaException {
		Midia midia = buscarPorId(m.getId());
		if(midia==null){
			throw new MidiaNaoEncontradaException(m.getId());
		}
		midias.remove(midia);
		fh.escreverMidiasNoArquivo(nomeArquivo, midias);
	}

	public void atualizar(Midia m) {
		Midia midiaAnterior = buscarPorId(m.getId());
		midias.remove(midiaAnterior);
		midias.add(m);
		fh.escreverMidiasNoArquivo(nomeArquivo, midias);
	}

	public Midia buscarPorId(Long id) {
		for (Midia m : midias) {
			if(m.getId().equals(id)){
				return m;
			}
		}
		log.info("ID " + id + " nao encontrado na lista de midias.");
		return null;
	}

}
