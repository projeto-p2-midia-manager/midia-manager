package br.cin.ufpe.manager.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager(String persistenceunitName){
		if(emf==null){
			emf = (EntityManagerFactory) Persistence.createEntityManagerFactory(persistenceunitName);
		}
		return EntityManagerFactory.getEntityManager(persistenceunitName);
	}

}
