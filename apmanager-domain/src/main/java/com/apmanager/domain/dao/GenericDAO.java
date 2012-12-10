/*
 * GenericDAO
*/

package com.apmanager.domain.dao;

import com.apmanager.domain.entity.Entity;

import javax.persistence.EntityManager;

/**
 *
 * @author luis
 */
public class GenericDAO<E extends Entity> {
    private EntityManager em;
    public GenericDAO(EntityManager em) {
        this.em = em;
    }
    
    public void save(E object){
        em.persist(object);
    }
    public void update(E object){
        em.merge(object);
    }
}
