/*
 * FuelType
 */
package com.apmanager.domain.entity;

import java.io.Serializable;

/**
 * Esta enum não implementa todos os métodos da Interface Entity, 
 * apenas o método para exibição do nome
 * @author luis
 * @since Nov 24, 2012
 */

public enum FuelType implements Entity{

    PETROL("Gasolina"),
    ALCOHOL("Álcool"),
    FLEX("Flex"),
    DIESEL("Diesel");

    private String name;

    private FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Serializable getId() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public void setId(Serializable id) {
        // do nothing;
    }

    @Override
    public void setStatus(boolean newStatus) {
       // do nothing
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
