package com.apmanager.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 */
public class EntityProvider {
    private static EntityManager em;
    
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
    }
    
}
