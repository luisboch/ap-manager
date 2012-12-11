/*
 * VehicleModel
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name="veiculos_modelos")
public class VehicleModel implements Entity {

    @Id
    @SequenceGenerator(name="vehicle-model-seq", allocationSize=1, sequenceName="veiculos_modelos_id_seq")
    @GeneratedValue(generator="vehicle-model-seq")
    private Integer id;

    @ManyToOne(fetch= FetchType.LAZY)
    private Vehicle vehicle;

    @Column(name="ano")
    private String year;

    @Column(name="nome")
    private String name;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    
    private boolean status;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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

    @Override
    public boolean isActive() {
        return status;
    }
}
