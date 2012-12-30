/*
 * Appliance
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@Table(name="aplicacoes")
@javax.persistence.Entity
public class Appliance implements Entity {

    @Id
    @SequenceGenerator(name="appliance-seq", sequenceName="aplicacoes_id_seq", allocationSize=1)
    @GeneratedValue(generator="appliance-seq")
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="produto_id")
    private Product product;

    @Column(name="descricao")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    private VehicleModel model;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
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
        return true;
    }

    @Override
    public void setStatus(boolean newStatus) {
        // Do nothing
    }

    @Override
    public String getDisplayName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
