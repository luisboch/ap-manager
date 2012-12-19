/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain;

import com.apmanager.domain.dao.impl.VehicleBrandDAO;
import com.apmanager.domain.entity.VehicleBrand;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author felipe
 */
public class VehicleBrandTest {
    
    @Test
    public void test(){
        
        EntityManager em = EntityProvider.getEntityManager();
        VehicleBrand vb = EntityProvider.createVehicleBrand();
        em.getTransaction().begin();
        em.remove(vb);
        em.getTransaction().commit();
        vb = EntityProvider.createVehicleBrand();
        vb.setName("teste 2 aborba");
        em.getTransaction().begin();
        em.merge(vb);
        em.getTransaction().commit();
        
        List<VehicleBrand> list = new VehicleBrandDAO(em).search("2");
        
        if (list.isEmpty()){
            throw new IllegalStateException("Expected more than zero results");
        }
        
    }
    
}
