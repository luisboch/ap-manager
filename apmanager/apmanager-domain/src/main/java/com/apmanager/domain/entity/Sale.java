package com.apmanager.domain.entity;

import com.apmanager.domain.exceptions.OutOfDiscountException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author luis
 */
@javax.persistence.Entity
@Table(name = "vendas")
public class Sale implements Entity {

    @Id
    @SequenceGenerator(name = "sale-seq", allocationSize = 1,
    sequenceName = "vendas_id_seq")
    @GeneratedValue(generator = "sale-seq")
    private Long id;

    private Float total;

    @Column(name = "data_criacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date openDate;

    @Column(name = "data_fechamento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date closeDate;

    @Column(name = "cancelada")
    private boolean canceled = false;

    @Column(name = "fechada")
    private boolean closed = false;

    @OneToMany(mappedBy = "sale",
    cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SaleProduct> products;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "computador_id")
    private Computer computer;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public List<SaleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SaleProduct> products) {
        this.products = products;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public String getDisplayName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStatus(boolean newStatus) {
        // Do nothing
    }

    public int getProductQuantity() {
        if (products == null) {
            return 0;
        }
        int total = 0;
        for (SaleProduct p : products) {
            if (p.getQuantity() != null) {
                total += p.getQuantity();
            }
        }
        return total;
    }
    
    public boolean isEmpty(){
        return getProductQuantity() == 0;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Sale other = (Sale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", total=" + total
                + ", openDate=" + openDate + ", closeDate=" + closeDate + '}';
    }
}
