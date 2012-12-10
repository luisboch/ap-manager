/*
 * Appliance
 */
package com.apmanager.domain.entity;

import java.io.Serializable;

/**
 *
 * @author luis
 */
public class Appliance implements Entity {

    private Long id;

    private Product product;

    private String description;

    private VehicleModel model;
    
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VehicleModel getModel() {
        return model;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    @Override
    public boolean isActive() {
        return status;
    }

    @Override
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }
}
