package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.VehicleModel;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class VehicleModelDAO extends GenericDAO<VehicleModel> {

    public VehicleModelDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<VehicleModel> search(String search) {
        search = search == null ? "" : search;
        String sql = "select v "
                + "from VehicleModel vm "
                + "join vm.vehicle v "
                + "where lower(v.name) like lower(:search) "
                + "or lower(v.observation) like lower(:search) "
                + "or lower(v.brand.name) like lower(:search) "
                + "or lower(vm.name) like (:search) or vm.year like :search";

        Query q = em.createQuery(sql);
        q.setParameter("search", "%".concat(search).concat("%"));

        return q.getResultList();
    }

    @Override
    public void save(VehicleModel object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
}
