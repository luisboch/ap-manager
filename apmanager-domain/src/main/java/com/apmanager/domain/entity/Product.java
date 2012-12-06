/*
 * Product
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
public class Product implements Entity {

    @Id
    @SequenceGenerator(name = "product-seq", sequenceName = "product_id_seq",
    allocationSize = 1)
    @GeneratedValue(generator = "product-seq")
    private Long id;

    private String name;

    @Transient
    private ProductBrand brand;

    @Transient
    private Date registerDate;

    @Transient
    private String description;

    @Transient
    private List<Appliance> appliances;

    @Transient
    private String code;

    @Transient
    private String barcode;

    @Transient
    private Integer maxDiscountPercent;

    @Transient
    private Float sellPrice;

    @Transient
    private Float purchuasePrice;

    @Transient
    private Integer quantity;

    @ManyToOne(fetch= FetchType.LAZY)
    private Shelf shelf;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductBrand getBrand() {
        return brand;
    }

    public void setBrand(ProductBrand brand) {
        this.brand = brand;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getMaxDiscountPercent() {
        return maxDiscountPercent;
    }

    public void setMaxDiscountPercent(Integer maxDiscountPercent) {
        this.maxDiscountPercent = maxDiscountPercent;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Float getPurchuasePrice() {
        return purchuasePrice;
    }

    public void setPurchuasePrice(Float purchuasePrice) {
        this.purchuasePrice = purchuasePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
