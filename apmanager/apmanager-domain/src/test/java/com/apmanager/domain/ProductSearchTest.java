/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain;

import com.apmanager.domain.dao.impl.ProductDAO;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class ProductSearchTest {
    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url",
                "jdbc:postgresql://localhost:5432/apmanager");
        map.put("eclipselink.ddl-generation", "none");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU",map);
        EntityManager em = emf.createEntityManager(map);
        ProductDAO dao = new ProductDAO(em);
        dao.search("");
    }
}
