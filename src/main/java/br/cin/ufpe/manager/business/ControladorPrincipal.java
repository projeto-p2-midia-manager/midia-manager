package br.cin.ufpe.manager.business;

import br.cin.ufpe.manager.cadastro.CadastroItens;
import br.cin.ufpe.manager.cadastro.CadastroMidia;
import br.cin.ufpe.manager.cadastro.CadastroPessoa;
import br.cin.ufpe.manager.entity.TipoRepositorio;

public class ControladorPrincipal {
	
	private CadastroPessoa cadastroPessoa;
	private CadastroMidia cadastroMidia;
	private CadastroItens cadastroItens;
	
	public ControladorPrincipal(){
		
	}
	
	public ControladorPrincipal(TipoRepositorio tipo){
		this.cadastroPessoa = new CadastroPessoa(tipo);
		this.cadastroMidia = new CadastroMidia(tipo);
		this.cadastroItens = new CadastroItens(tipo);
	}
	
	public CadastroPessoa getCadastroPessoa() {
		return cadastroPessoa;
	}

	public void setCadastroPessoa(CadastroPessoa cadastroPessoa) {
		this.cadastroPessoa = cadastroPessoa;
	}

	public CadastroMidia getCadastroMidia() {
		return cadastroMidia;
	}

	public void setCadastroMidia(CadastroMidia cadastroMidia) {
		this.cadastroMidia = cadastroMidia;
	}

	public CadastroItens getCadastroItens() {
		return cadastroItens;
	}

	public void setCadastroItens(CadastroItens cadastroItens) {
		this.cadastroItens = cadastroItens;
	}
	

}
