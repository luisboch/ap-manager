/*
 * GenericDAO
 */
package com.apmanager.domain.dao;

import com.apmanager.domain.entity.Entity;
import java.io.Serializable;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public abstract class GenericDAO<E extends Entity> implements EntityDAO<E> {

    private static final Logger log = LoggerFactory.getLogger(GenericDAO.class);

    private Class<E> clazz;

    protected EntityManager em;

    public GenericDAO(EntityManager em, Class<E> targetEntity) {
        this.em = em;
        clazz = targetEntity;
    }

    @Override
    public void save(E object) {
        em.persist(object);
    }

    @Override
    public void update(E object) {
        em.merge(object);
    }

    @Override
    public void delete(E object) {
        em.remove(object);
    }

    public E getById(Serializable id) {
        log.info("Loading Entity of class {} with id {}", clazz.getSimpleName(), id);
        return this.em.find(clazz, id);
    }
}
