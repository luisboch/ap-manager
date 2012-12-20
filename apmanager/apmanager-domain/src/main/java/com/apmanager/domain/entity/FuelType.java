/*
 * FuelType
 */
package com.apmanager.domain.entity;

/**
 *
 * @author luis
 * @since Nov 24, 2012
 */
public enum FuelType {

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
    
}
