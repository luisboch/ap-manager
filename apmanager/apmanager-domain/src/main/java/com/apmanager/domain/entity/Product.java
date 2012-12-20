/*
 * Product
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    
    private String additionalCode;

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

    private Integer minQuantity; 
    
    private boolean status = true;
    
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

    /**
     *
     * @return
     */
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public boolean isActive() {
        return status;
    }
    
    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public String getAdditionalCode() {
        return additionalCode;
    }

    public void setAdditionalCode(String additionalCode) {
        this.additionalCode = additionalCode;
    }

    @Override
    public String getDisplayName() {
        return this.name + " " + this.code + " " + this.additionalCode;
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", brand=" + brand + '}';
    }
    
}
