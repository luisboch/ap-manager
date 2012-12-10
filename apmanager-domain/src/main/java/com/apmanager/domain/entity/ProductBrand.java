/*
 * VehicleMark
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name="marcas_de_produtos")
public class ProductBrand implements Entity {

    @Id
    @SequenceGenerator(name="productbrand-seq", allocationSize=1, sequenceName="marcas_de_produtos_id_seq")
    @GeneratedValue(generator="productbrand-seq")
    private Integer id;

    @Column(name="nome", nullable = false)
    private String name;

    @Column(name="descricao")
    private String description;

    @Column(name="data_de_registro", nullable=false, updatable=false)
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    
    @Column(name="status", nullable=false)
    private boolean status = true;

    /**
     *
     * @return
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(Serializable id) {
        this.id = (Integer) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isActive() {
        return status;
    }
    
}
