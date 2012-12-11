/*
 * Vehicle
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name = "veiculos")
public class Vehicle implements Entity {

    @Id
    @SequenceGenerator(name = "vehicle-seq", allocationSize = 1,
    sequenceName = "veiculos_id_seq")
    @GeneratedValue(generator = "vehicle-seq")
    private Integer id;

    @Column(name = "observacao")
    private String observation;

    @Column(name = "nome")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private VehicleBrand brand;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
