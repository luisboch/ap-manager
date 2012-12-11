package com.apmanager.domain;

import com.apmanager.domain.dao.impl.ProductBrandDAO;
import com.apmanager.domain.dao.impl.VehicleBrandDAO;
import com.apmanager.domain.dao.impl.VehicleDAO;
import com.apmanager.domain.dao.impl.VehicleModelDAO;
import com.apmanager.domain.entity.FuelType;
import com.apmanager.domain.entity.ProductBrand;
import com.apmanager.domain.entity.Vehicle;
import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.domain.entity.VehicleModel;
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

    private static VehicleBrandDAO vehicleBrandDAO;

    private static VehicleDAO vehicleDAO;
    
    private static VehicleModelDAO vehicleModelDAO;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        productBrandDAO = new ProductBrandDAO(em);
        vehicleBrandDAO = new VehicleBrandDAO(em);
        vehicleDAO = new VehicleDAO(em);
        vehicleModelDAO = new VehicleModelDAO(em);
    }

    public static ProductBrand createProductBrand() {
        ProductBrand pb = new ProductBrand();
        pb.setName("teste JPA");
        pb.setDescription("teste");
        em.getTransaction().begin();
        productBrandDAO.save(pb);
        em.getTransaction().commit();
        return pb;
    }

    public static VehicleBrand createVehicleBrand() {
        VehicleBrand vb = new VehicleBrand();
        vb.setName("teste Aborba");
        vb.setDescription("descreption funcas");
        em.getTransaction().begin();
        vehicleBrandDAO.save(vb);
        em.getTransaction().commit();
        return vb;
    }

    public static Vehicle createVehicle() {
        return createVehicle(createVehicleBrand());
    }

    public static Vehicle createVehicle(VehicleBrand brand) {
        Vehicle v = new Vehicle();
        v.setName("teste Aborba");
        v.setObservation("observation");
        v.setBrand(brand);
        em.getTransaction().begin();
        vehicleDAO.save(v);
        em.getTransaction().commit();
        return v;
    }

    public static VehicleModel createVehicleModel() {
        return createVehicleModel(createVehicle());
    }
    
    public static VehicleModel createVehicleModel(Vehicle vehicle) {
        VehicleModel v = new VehicleModel();
        v.setName("teste Aborba");
        v.setFuelType(FuelType.PETROL);
        v.setVehicle(vehicle);
        v.setYear("2010/2012");
        em.getTransaction().begin();
        vehicleModelDAO.save(v);
        em.getTransaction().commit();
        return v;
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}
