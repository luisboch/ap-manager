/*
 * VehicleMark
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "prateleiras")
public class Shelf implements Entity {

    @Id
    @SequenceGenerator(name = "shelf-seq", sequenceName = "prateleiras_id_seq",
    allocationSize = 1)
    @GeneratedValue(generator = "shelf-seq")
    private Integer id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "descricao")
    private String description;

    private boolean status = true;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_de_registro", nullable = false, updatable = false)
    private Date registerDate;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        status = newStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Shelf other = (Shelf) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getDisplayName() {
        return this.code;
    }
}
