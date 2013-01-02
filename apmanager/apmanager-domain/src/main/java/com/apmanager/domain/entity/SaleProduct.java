package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name = "vendas_produtos")
public class SaleProduct implements Entity {

    @Id
    @SequenceGenerator(name = "saleproduct-seq",
    sequenceName = "vendas_produtos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "saleproduct-seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Product product;
    
    @ManyToOne(optional=false, fetch= FetchType.EAGER)
    @JoinColumn(name="venda_id", nullable=false)
    private Sale sale;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "preco_compra")
    private Float buyPrice;

    @Column(name = "preco_venda")
    private Float sellPrice;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String getDisplayName() {
        return this.product != null ? this.product.getDisplayName() : "";
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public void setStatus(boolean newStatus) {
        // Do nothing
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public String toString() {
        return "SaleProduct{" + "product=" + product + ", sale=" + sale + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.product);
        hash = 31 * hash + Objects.hashCode(this.sale);
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
        final SaleProduct other = (SaleProduct) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.sale, other.sale)) {
            return false;
        }
        return true;
    }

}
