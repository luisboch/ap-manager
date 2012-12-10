package com.apmanager.domain;

import com.apmanager.domain.dao.impl.ProductBrandDAO;
import com.apmanager.domain.entity.ProductBrand;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 */
public class EntityProvider {
    private static EntityManager em;
    private static ProductBrandDAO productBrandDAO;
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        productBrandDAO = new ProductBrandDAO(em);
    }
    
    public static ProductBrand createProductBrand(){
        ProductBrand pb = new ProductBrand();
        pb.setName("teste JPA");
        pb.setDescription("teste");
        em.getTransaction().begin();
        productBrandDAO.save(pb);
        em.getTransaction().commit();
        return pb;
    }

    public static EntityManager getEntityManager() {
        return em;
    }
    
}
