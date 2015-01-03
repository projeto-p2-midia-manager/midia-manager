package br.cin.ufpe.manager.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManager {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager(String persistenceunitName){
		if(emf==null){
			emf = Persistence.createEntityManagerFactory(persistenceunitName);
		}
		return emf.createEntityManager();
	}

}
