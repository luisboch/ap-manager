/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.beans;

/**
 *
 * @author luis.boch
 */
public class ProductCart {

    private Long id;
    private String name;
    private Float unitaryValue;
    private Float total;
    private Integer quantity;

    public ProductCart() {
    }

    public ProductCart(Long id, String name, Float unitaryValue, Float total, Integer quantity) {
        this.id = id;
        this.name = name;
        this.unitaryValue = unitaryValue;
        this.total = total;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Float unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}