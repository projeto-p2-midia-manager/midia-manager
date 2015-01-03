package br.cin.ufpe.manager.persistence.bd;

import java.util.List;

import javax.persistence.EntityManager;

import br.cin.ufpe.manager.entity.ItemBackup;
import br.cin.ufpe.manager.interfaces.IRepositorio;
import br.cin.ufpe.manager.util.FabricaEntityManager;

public class RepositorioItensBD implements IRepositorio<ItemBackup> {
	
	private EntityManager em;
	
	public RepositorioItensBD(){
		
	}
	
	public RepositorioItensBD(String pu){
		this.em = FabricaEntityManager.getEntityManager(pu);
	}

	@SuppressWarnings("unchecked")
	public List<ItemBackup> listar() {
		return em.createQuery("SELECT i FROM ItemBackup i").getResultList();
	}

	public void inserir(ItemBackup i) {
		em.persist(i);
		em.flush();
	}

	public void remover(ItemBackup i) {
		ItemBackup item = buscarPorId(i.getId());
		em.remove(item);
		em.flush();
	}

	public void atualizar(ItemBackup i) {
		em.merge(i);
		em.flush();
	}

	public ItemBackup buscarPorId(Long id) {
		ItemBackup item = em.find(ItemBackup.class, id);
		return item;
	}

}
