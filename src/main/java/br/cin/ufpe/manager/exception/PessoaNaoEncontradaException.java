package br.cin.ufpe.manager.exception;

public class PessoaNaoEncontradaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	public PessoaNaoEncontradaException(Long id) {
		this.id = id;
	}
	
	@Override
	public String getMessage(){
		return "A pessoa de id igual a " + this.id + " não foi encontrada."; 
	}

}
