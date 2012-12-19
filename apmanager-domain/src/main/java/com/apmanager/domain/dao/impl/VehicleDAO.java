package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Vehicle;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class VehicleDAO extends GenericDAO<Vehicle> {

    public VehicleDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<Vehicle> search(String search) {
        search = search == null ? "" : search;
        String sql = "select v "
                + "from Vehicle v "
                + "where v.status = true "
                + "and (lower(v.name) like lower(:search) "
                + "or lower(v.observation) like lower(:search) "
                + "or lower(v.brand.name) like lower(:search)) ";

        Query q = em.createQuery(sql);
        q.setParameter("search", "%".concat(search).concat("%"));

        return q.getResultList();
    }

    @Override
    public void save(Vehicle object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
}
