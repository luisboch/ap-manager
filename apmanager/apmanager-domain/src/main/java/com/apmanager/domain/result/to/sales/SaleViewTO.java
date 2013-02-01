/*
 * SaleViewTO.java
 */
package com.apmanager.domain.result.to.sales;

import com.apmanager.domain.entity.Sale;
import java.util.Objects;

/**
 *
 * @author luis
 */
public class SaleViewTO {
    private Sale sale;
    private int productsQuantity;
    private Float total;
    private Float totalL;
    private Float margin;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getTotalL() {
        return totalL;
    }

    public void setTotalL(Float totalL) {
        this.totalL = totalL;
    }

    public Float getMargin() {
        return margin;
    }

    public void setMargin(Float margin) {
        this.margin = margin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.sale);
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
        final SaleViewTO other = (SaleViewTO) obj;
        if (!Objects.equals(this.sale, other.sale)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SaleViewTO{" + "sale=" + sale + ", total=" + total + ", totalL=" + totalL + ", margin=" + margin + '}';
    }
}
