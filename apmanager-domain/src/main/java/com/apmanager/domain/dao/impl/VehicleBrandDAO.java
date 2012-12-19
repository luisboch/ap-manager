package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.VehicleBrand;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
public class VehicleBrandDAO extends GenericDAO<VehicleBrand> {

    public VehicleBrandDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<VehicleBrand> search(String search) {

        String sql = "select vb from VehicleBrand vb where vb.status = true and (lower(vb.name) "
                + "like lower(:search) or lower(vb.description) like "
                + "lower(:search))";
        Query q = em.createQuery(sql);
        
        q.setParameter("search", "%"+search+"%");
        
        return q.getResultList();
    }

    @Override
    public void save(VehicleBrand object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
    
    
    
}
