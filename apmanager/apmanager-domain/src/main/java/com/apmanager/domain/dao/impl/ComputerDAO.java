/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Computer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class ComputerDAO extends GenericDAO<Computer> {

    public ComputerDAO(EntityManager em) {
        super(em, Computer.class);
    }

    @Override
    public List<Computer> search(String search) {
        search = search == null ? "" : search;
        String jpql = "select c from Computer c where c.status = true "
                + "and ( lower(c.name) like lower(:search) "
                + "or c.ipv4 like :search or c.ipv6 like :search)  ";
        Query q = em.createQuery(jpql);
        q.setParameter("search", "%".concat(search).concat("%"));
        return q.getResultList();
    }
}
