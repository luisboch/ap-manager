package com.apmanager.service;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Entity;
import com.apmanager.service.exceptions.ValidationException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public abstract class BasicService<T extends Entity, D extends GenericDAO<T>> {
    
    private static final Logger log =  LoggerFactory.getLogger(BasicService.class);
    protected EntityManager emanager = Provider.getEntityManager();
    protected D dao;

    /**
     * Save an instance of com.apmanager.domain.entity.Entity
     *
     * @param object
     * @throws Exception
     */
    public void save(T object) throws Exception {
        validate(object);
        emanager.getTransaction().begin();
        try {
            dao.save(object);
            emanager.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }

    }

    /**
     * Update an instance of com.apmanager.domain.entity.Entity
     *
     * @param object
     * @throws Exception
     */
    public void update(T object) throws Exception {
        validate(object);
        emanager.getTransaction().begin();
        try {
            dao.update(object);
            emanager.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }

    }

    /**
     * Delete an instance of com.apmanager.domain.entity.Entity
     * Waring: this method only set objecto to active = false.
     * @param object
     * @throws Exception
     */
    public void delete(T object) throws Exception {
        emanager.getTransaction().begin();
        object.setStatus(false);
        try {
            dao.update(object);
            emanager.getTransaction().commit();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }
        emanager.getTransaction().commit();
    }

    /**
     * Save an List of com.apmanager.domain.entity.Entity
     *
     * @param objects
     * @throws Exception
     */
    public void save(List<T> objects) throws Exception {
        emanager.getTransaction().begin();
        try {
            for (T obj : objects) {
                validate(obj);
                dao.save(obj);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }
        emanager.getTransaction().commit();
    }

    /**
     * Update an List of com.apmanager.domain.entity.Entity
     *
     * @param objects
     * @throws Exception
     */
    public void update(List<T> objects) throws Exception {

        emanager.getTransaction().begin();
        try {
            for (T obj : objects) {
                validate(obj);
                dao.update(obj);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }
        emanager.getTransaction().commit();

    }

    /**
     * Delete an List of com.apmanager.domain.entity.Entity
     * Waring: this method only set objecto to active = false.
     * @param objects
     * @throws Exception
     */
    public void delete(List<T> objects) throws Exception {
        emanager.getTransaction().begin();
         try {
            for (T obj : objects) {
                obj.setStatus(false);
                dao.update(obj);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            emanager.getTransaction().rollback();
            throw e;
        }
        emanager.getTransaction().commit();
    }
    public T getById(Serializable id){
        return dao.getById(id);
    }
    public List<T> search(String search){
        return dao.search(search);
    }
    
    public abstract void validate(T object) throws ValidationException;
}
