package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Vehicle;
import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.domain.entity.VehicleModel;
import com.apmanager.domain.utils.DAOUtils;
import java.io.Serializable;
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
        super(em, Vehicle.class);
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
        Date d = new Date();
        object.setRegisterDate(d);
        if (object.getVehicleModels() != null) {
            for (VehicleModel m : object.getVehicleModels()) {
                m.setRegisterDate(d);
            }
        }
        super.save(object);
    }

    @Override
    public void update(Vehicle object) {

        Date d = new Date();
        if (object.getVehicleModels() != null) {
            for (VehicleModel m : object.getVehicleModels()) {
                if (m.getRegisterDate() == null) {
                    m.setRegisterDate(d);
                }
            }
        }
        List<Serializable> ids = DAOUtils.toList(object.getVehicleModels());
       
        // seta para false os inativos;
        String sql = "update VehicleModel v set v.status = false where v.vehicle = :vehicle ";
        if (!ids.isEmpty()) {
            sql += "and id not in :models";
        }

        Query q = em.createQuery(sql);

        q.setParameter("vehicle", object);

        if (object.getVehicleModels() != null && !object.getVehicleModels().isEmpty()) {
            q.setParameter("models", ids);
        }

        q.executeUpdate();

        super.update(object);
    }

    public List<Vehicle> getVehiclesByBrand(VehicleBrand brand) {
        String sql = "select v from Vehicle v where v.brand = :brand";
        Query q = em.createQuery(sql);
        q.setParameter("brand", brand);
        return q.getResultList();
    }
}
