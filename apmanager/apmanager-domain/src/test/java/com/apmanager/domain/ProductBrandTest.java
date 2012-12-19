/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain;

import com.apmanager.domain.dao.impl.ProductBrandDAO;
import com.apmanager.domain.entity.ProductBrand;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class ProductBrandTest {
    
    @Test
    public void test(){
        ProductBrand pb = EntityProvider.createProductBrand();
        EntityManager em = EntityProvider.getEntityManager();
        ProductBrandDAO dao = new ProductBrandDAO(em);
        
        // Testa Deleção
        em.getTransaction().begin();
        dao.delete(pb);
        em.getTransaction().commit();
        
        // Testa o update
        pb = EntityProvider.createProductBrand();
        em.getTransaction().begin();
        dao.update(pb);
        em.getTransaction().commit();
        
        List<ProductBrand> list = dao.search("teste");
        
    };
}
