package br.cin.ufpe.manager.exception;

public class ItemNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public ItemNaoEncontradoException(Long id) {
		this.id = id;
	}
	
	@Override
	public String getMessage(){
		return "O item de id igual a " + this.id + " não foi encontrado."; 
	}		

}
