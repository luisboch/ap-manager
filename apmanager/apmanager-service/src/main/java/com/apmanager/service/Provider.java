/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class Provider {

    private static final Logger log = LoggerFactory.getLogger(Provider.class);

    private static EntityManager em;

    static {
        
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url",
                "jdbc:postgresql://" + Config.databaseHost + ":5432/"
                + Config.databaseName);
        map.put("javax.persistence.jdbc.password", Config.databasePassword);

        map.put("javax.persistence.jdbc.user", Config.databaseUser);
        log.info("Connecting to host [{}], database [{}]", Config.databaseHost, Config.databaseName);
        log.info("Starting Entity Manager...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apmanager-pu",map);
        em = emf.createEntityManager(map);
        log.info("...Entity Manager Started");
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}
