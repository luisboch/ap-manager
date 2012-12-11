package com.apmanager.domain;

import com.apmanager.domain.dao.impl.VehicleDAO;
import com.apmanager.domain.entity.Vehicle;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class VehicleTest {
    @Test
    public void test(){
                EntityManager em = EntityProvider.getEntityManager();
        Vehicle vb = EntityProvider.createVehicle();
        em.getTransaction().begin();
        em.remove(vb);
        em.getTransaction().commit();
        vb = EntityProvider.createVehicle();
        vb.setName("teste 2 aborba");
        em.getTransaction().begin();
        em.merge(vb);
        em.getTransaction().commit();
        
        List<Vehicle> list = new VehicleDAO(em).search("2");
        
        if (list.isEmpty()){
            throw new IllegalStateException("Expected more than zero results");
        }

    }
}
