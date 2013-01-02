/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name = "computadores")
public class Computer implements Entity {

    @Id
    @SequenceGenerator(name="computer-seq", sequenceName="computadores_id_seq", 
            allocationSize=1)
    @GeneratedValue(generator="computer-seq")
    private Integer id;

    private String ipv4;

    private String ipv6;

    @Column(name="nome")
    private String name;

    private boolean status = true;

    public Computer() {
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDisplayName() {
        return this.name + "[ " + (ipv4 != null ? ipv4 : ipv6) + " ]";
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
        return this.status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Computer other = (Computer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Computer{ id=" + id + ", ipv4=" + ipv4 + ", ipv6=" + ipv6 + ", name=" + name + ", status=" + status + '}';
    }
    
    
    
}

