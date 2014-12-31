package br.cin.ufpe.manager.persistence.bd;

import java.util.List;

import javax.persistence.EntityManager;

import br.cin.ufpe.manager.entity.Pessoa;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.EntityManagerFactory;

public class RepositorioPessoasBD implements IRepositorio<Pessoa> {
	
	private EntityManager em;
	
	public RepositorioPessoasBD(){
		
	}
	
	public RepositorioPessoasBD(String pu){
		this.em = EntityManagerFactory.getEntityManager(pu);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		return em.createQuery("SELECT p FROM Pessoa p").getResultList();
	}

	public void inserir(Pessoa p) {
		em.persist(p);
		em.flush();
	}

	public void remover(Pessoa p) {
		Pessoa pessoa = buscarPorId(p.getId());
		em.remove(pessoa);
		em.flush();		
	}

	public void atualizar(Pessoa p) {
		em.merge(p);
		em.flush();
	}

	public Pessoa buscarPorId(Long id) {
		Pessoa pessoa = em.find(Pessoa.class, id);
		return pessoa;
	}

}
