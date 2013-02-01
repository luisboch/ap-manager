package com.apmanager.domain.result.to.sales;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author luis
 */
public class SaleViewTotalTO {

    private Float total;

    private Float totalL;

    private Float margin;

    private List<SaleViewTO> sales;

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

    public List<SaleViewTO> getSales() {
        return sales == null ? sales = new LinkedList<>() : sales;
    }

    public void setSales(List<SaleViewTO> sales) {
        this.sales = sales;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final SaleViewTotalTO other = (SaleViewTotalTO) obj;
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.totalL, other.totalL)) {
            return false;
        }
        if (!Objects.equals(this.margin, other.margin)) {
            return false;
        }
        if (!Objects.equals(this.sales, other.sales)) {
            return false;
        }
        return true;
    }
}
