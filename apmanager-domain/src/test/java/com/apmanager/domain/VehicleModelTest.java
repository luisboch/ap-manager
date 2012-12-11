package com.apmanager.domain;

import com.apmanager.domain.dao.impl.VehicleModelDAO;
import com.apmanager.domain.entity.VehicleModel;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class VehicleModelTest {

    @Test
    public void test() {
        
        EntityManager em = EntityProvider.getEntityManager();
        VehicleModel vb = EntityProvider.createVehicleModel();
        
        em.getTransaction().begin();
        em.remove(vb);
        em.getTransaction().commit();
        vb = EntityProvider.createVehicleModel();
        vb.setName("teste 2 aborba");
        em.getTransaction().begin();
        em.merge(vb);
        em.getTransaction().commit();

        List<VehicleModel> list = new VehicleModelDAO(em).search("2");

        if (list.isEmpty()) {
            throw new IllegalStateException("Expected more than zero results");
        }

    }
}
