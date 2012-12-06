/*
 * Basic
*/

package com.apmanager.domain;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Product;
import com.apmanager.domain.entity.Shelf;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.QueryHint;
import org.eclipse.persistence.config.QueryHints;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class Basic {
    @Test
    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        GenericDAO<Product> dao = new GenericDAO<>(em);
        
        Shelf s = new Shelf();
        s.setCode("00001");
        s.setDescription("aaaa");
        
        s.setRegisterDate(new Date());
        
        em.persist(s);
        
        for(int i =0 ;i < 10; i++){
            Product p = new Product();
            p.setName("p-"+i);
            p.setShelf(s);
            em.persist(p);
        }
        
        em.getTransaction().commit();
        
        
        
        Query q = em.createQuery("select p from Product p where p.name like ?1");
        //q.setHint(QueryHints.REFRESH_CASCADE, true);
        q.setParameter(1, "p-1");
        em.clear();
        Product p  = (Product) q.getSingleResult();
        // Here we have an log of result.
        Shelf shelf = p.getShelf();
        Integer id = shelf.getId();
        
    }
}
