/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
class Provider {
    private static final Logger log = LoggerFactory.getLogger(Provider.class);
    private static EntityManager em;
    static{
        log.info("Starting Entity Manager...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apmanager-pu");
        em = emf.createEntityManager();
        log.info("...Entity Manager Started");
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}
