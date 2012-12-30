/*
 * Vehicle
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @JoinColumn(name = "marca_id")
    private VehicleBrand brand;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<VehicleModel> vehicleModels = new ArrayList<>();
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_de_registro", nullable = false, updatable = false)
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

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels == null ? vehicleModels = new ArrayList<>() : vehicleModels;
    }

    public void setVehicleModels(List<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
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

    @Override
    public String getDisplayName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", name=" + name + ", brand=" + brand + '}';
    }
    
}
