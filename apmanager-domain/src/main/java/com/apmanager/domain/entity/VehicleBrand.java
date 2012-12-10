/*
 * VehicleMark
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author luis
 */

@javax.persistence.Entity 
@Table (name="marcas_de_veiculos")
public class VehicleBrand implements Entity {
    
    @Id
    @SequenceGenerator(name="VehicleBrand-seq", allocationSize=1,
            sequenceName="marcas_de_veiculos_id_seq")
    @GeneratedValue(generator="VehicleBrand-seq")
    private Integer id;
    
    @Column (name="nome", nullable=false)
    private String name;

    @Column (name="descricao")
    private String description;

    @Column (name="data_do_registro", nullable=false, updatable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date registerDate;
    
    private boolean status;

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
    public boolean isActive() {
        return status;
    }

    @Override
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }
}
