/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Computer;
import com.apmanager.domain.entity.Sale;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class SaleDAO extends GenericDAO<Sale> {

    public SaleDAO(EntityManager em, Class<Sale> targetEntity) {
        super(em, targetEntity);
    }

    
    @Override
    public List<Sale> search(String search) {
        List<Sale> sales;
        String sql = "select distinct s "
                + "from sale s "
                + "join s.products p "
                + "where lower(p.name) like (:search) ";
        Query q = em.createQuery(sql);
        q.setParameter("search", search);
        sales = q.getResultList();
        return sales;
    }
    
    public Sale getActive(Computer computer){
        Sale sales;
        String sql = "select distinct s "
                + "from sale s "
                + "where s.computer = ?1 "
                + "and s.closed = false "
                + "and s.canceled = false";
        Query q = em.createQuery(sql);
        q.setParameter(1, computer);
        sales = (Sale) q.getSingleResult();
        return sales;
    }
    
}
