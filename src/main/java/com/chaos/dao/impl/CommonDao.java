package com.chaos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public abstract class CommonDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
       
    }

	public EntityManager getEm() {
		if( em == null){
			 em = emf.createEntityManager();
		}
		return em;
	}

	
    
}
