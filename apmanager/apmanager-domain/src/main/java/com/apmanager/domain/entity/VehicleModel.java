/*
 * VehicleModel
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "veiculos_modelos")
public class VehicleModel implements Entity {

    @Id
    @SequenceGenerator(name = "vehicle-model-seq", allocationSize = 1, sequenceName = "veiculos_modelos_id_seq")
    @GeneratedValue(generator = "vehicle-model-seq")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id")
    private Vehicle vehicle;

    @Column(name = "ano")
    private String year;

    @Column(name = "potencia", nullable = false)
    private Float potency;

    @Column(name = "nome")
    private String name;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Temporal(TemporalType.TIMESTAMP)
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

    public Float getPotency() {
        return potency;
    }

    public void setPotency(Float potency) {
        this.potency = potency;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Integer) id;
    }

    @Override
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean isActive() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.vehicle);
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
        final VehicleModel other = (VehicleModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.vehicle, other.vehicle)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "VehicleModel{" + "id=" + id + ", vehicle=" + vehicle
                + ", year=" + year + ", potency=" + potency + ", name=" + name
                + ", fuelType=" + fuelType + '}';
    }

    @Override
    public String getDisplayName() {
        return this.name + " - " + this.year + " - "
                + this.potency + " - " + this.getFuelType().getDisplayName();
    }
}
