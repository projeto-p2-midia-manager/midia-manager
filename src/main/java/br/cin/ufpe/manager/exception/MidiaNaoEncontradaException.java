package br.cin.ufpe.manager.exception;

public class MidiaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public MidiaNaoEncontradaException(Long id) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String getMessage(){
		return "A midia de id igual a " + this.id + " não foi encontrada."; 
	}	
	

}
