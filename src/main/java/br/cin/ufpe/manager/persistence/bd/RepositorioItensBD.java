package br.cin.ufpe.manager.persistence.bd;

import java.util.List;

import javax.persistence.EntityManager;

import br.cin.ufpe.manager.entity.ItemMidia;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.FabricaEntityManager;

public class RepositorioItensBD implements IRepositorio<ItemMidia> {
	
	private EntityManager em;
	
	public RepositorioItensBD(){
		
	}
	
	public RepositorioItensBD(String pu){
		this.em = FabricaEntityManager.getEntityManager(pu);
	}

	@SuppressWarnings("unchecked")
	public List<ItemMidia> listar() {
		return em.createQuery("SELECT i FROM ItemMidia i").getResultList();
	}

	public void inserir(ItemMidia i) {
		em.persist(i);
		em.flush();
	}

	public void remover(ItemMidia i) {
		ItemMidia item = buscarPorId(i.getId());
		em.remove(item);
		em.flush();
	}

	public void atualizar(ItemMidia i) {
		em.merge(i);
		em.flush();
	}

	public ItemMidia buscarPorId(Long id) {
		ItemMidia item = em.find(ItemMidia.class, id);
		return item;
	}

}
