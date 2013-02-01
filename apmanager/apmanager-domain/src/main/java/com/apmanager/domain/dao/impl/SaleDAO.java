/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Computer;
import com.apmanager.domain.entity.Sale;
import com.apmanager.domain.entity.SaleProduct;
import com.apmanager.domain.result.to.sales.SaleViewTO;
import com.apmanager.domain.result.to.sales.SaleViewTotalTO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class SaleDAO extends GenericDAO<Sale> {

    public SaleDAO(EntityManager em) {
        super(em, Sale.class);
    }

    @Override
    public List<Sale> search(String search) {
        List<Sale> sales;
        String sql = "select distinct s "
                + "from Sale s "
                + "join s.products p "
                + "where lower(p.name) like (:search) ";
        Query q = em.createQuery(sql);
        q.setParameter("search", search);
        sales = q.getResultList();
        return sales;
    }

    public Sale getActive(Computer computer) {
        Sale sales;
        String sql = "select distinct s "
                + "from Sale s "
                + "where s.computer = ?1 "
                + "and s.closed = false "
                + "and s.canceled = false";
        Query q = em.createQuery(sql);
        q.setParameter(1, computer);
        sales = (Sale) q.getSingleResult();
        return sales;
    }

    public SaleViewTotalTO getSalesByDate(Date startDate, Date endDate) {
        SaleViewTotalTO totalTO = new SaleViewTotalTO();
        List<SaleViewTO> sales = totalTO.getSales();

        String jpql = "select distinct s from Sale s where s.closedDate between ?1 and ?2 and s.canceled = false";
        Query q = em.createQuery(jpql);
        q.setParameter(1, startDate);
        q.setParameter(2, endDate);
        List<Sale> result = q.getResultList();

        Float totalValue = 0f;
        Float totalL = 0f;
        // Faz um loop nas vendas.
        for (Sale sale : result) {

            SaleViewTO t = new SaleViewTO();
            t.setSale(sale);
            t.setTotal(sale.getTotal());

            // Calcula o lucro
            List<SaleProduct> products = sale.getProducts();
            float totalBuyPrice = 0f;
            for (SaleProduct p : products) {
                totalBuyPrice += p.getQuantity().floatValue() * p.getProduct().getPurchuasePrice();
            }

            // Calcula o valor líquido
            t.setTotalL(sale.getTotal() - totalBuyPrice);

            // Calcula o percentual de lucro
            t.setMargin(t.getTotalL() / sale.getTotal() );

            // Pega a quantidade de produtos da venda.
            t.setProductsQuantity(sale.getProductQuantity());

            // Adiciona à lista de retorno
            sales.add(t);

            // Acumula os totalizadores
            totalValue += t.getTotal();
            totalL += t.getTotalL();
        }

        // Calcula a margem total
        totalTO.setMargin(totalL/totalValue);
        totalTO.setTotal(totalValue);
        totalTO.setTotalL(totalL);

        return totalTO;
    }
}
