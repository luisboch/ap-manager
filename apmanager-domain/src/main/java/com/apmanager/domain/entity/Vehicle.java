/*
 * Vehicle
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author luis
 */
public class Vehicle implements Entity {

    private Integer id;

    private String observation;

    private String name;

    private VehicleBrand brand;

    private Date registerDate;
    
    private boolean status = true;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Integer) id;
    }

    @Override
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

    public boolean isActive() {
        return status;
    }
    
}
