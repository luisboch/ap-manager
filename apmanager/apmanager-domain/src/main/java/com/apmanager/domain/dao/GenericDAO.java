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
public abstract class GenericDAO<E extends Entity> implements EntityDAO<E> {
    
    protected EntityManager em;
    public GenericDAO(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void save(E object){
        em.persist(object);
    }
    
    @Override
    public void update(E object){
        em.merge(object);
    }
    
    @Override
    public void delete(E object) {
        em.remove(object);
    }
    
}
