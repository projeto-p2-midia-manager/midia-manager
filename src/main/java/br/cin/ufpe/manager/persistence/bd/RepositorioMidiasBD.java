package br.cin.ufpe.manager.persistence.bd;

import java.util.List;

import javax.persistence.EntityManager;

import br.cin.ufpe.manager.entity.Midia;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.EntityManagerFactory;

public class RepositorioMidiasBD implements IRepositorio<Midia> {
	
	private EntityManager em;
	
	public RepositorioMidiasBD() {
	}
	
	public RepositorioMidiasBD(String pu){
		this.em = EntityManagerFactory.getEntityManager(pu);
	}

	@SuppressWarnings("unchecked")
	public List<Midia> listar() {
		return em.createNamedQuery("SELECT m FROM Midia m").getResultList();
	}

	public void inserir(Midia m) {
		em.persist(m);
		em.flush();
	}

	public void remover(Midia m) {
		Midia midia = buscarPorId(m.getId());
		em.remove(midia);
		em.flush();
	}

	public void atualizar(Midia m) {
		em.merge(m);
		em.flush();
	}

	public Midia buscarPorId(Long id) {
		Midia midia = em.find(Midia.class, id);
		return midia;
	}

}
