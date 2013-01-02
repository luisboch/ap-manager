/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Shelf;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class ShelfDAO extends GenericDAO<Shelf> {

    public ShelfDAO(EntityManager em) {
        super(em, Shelf.class);
    }
    
    @Override
    public List<Shelf> search(String search) {
        String sql = "select s "
                + "from Shelf s "
                + "where s.status = true "
                + "and (lower(s.code) like lower(:search) "
                + "or lower(s.description) like lower(:search) "
                + ")";
        Query q = em.createQuery(sql);
        q.setParameter("search", "%".concat(search).concat("%"));
                
        return q.getResultList();
    }

    @Override
    public void save(Shelf object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
    
    
    
}
