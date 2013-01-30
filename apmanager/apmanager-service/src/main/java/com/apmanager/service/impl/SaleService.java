/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.SaleDAO;
import com.apmanager.domain.entity.Computer;
import com.apmanager.domain.entity.Sale;
import com.apmanager.domain.entity.SaleProduct;
import com.apmanager.domain.exceptions.OutOfDiscountException;
import com.apmanager.service.BasicService;
import com.apmanager.service.ServiceAction;
import com.apmanager.service.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.NoResultException;

/**
 *
 * @author luis
 */
public class SaleService extends BasicService<Sale, SaleDAO> {

    public SaleService() {
        dao = new SaleDAO(emanager);
    }

    @Override
    public void validate(Sale object, ServiceAction action) throws ValidationException {
        ValidationException v = new ValidationException(Sale.class);

        if (object.getComputer() == null) {
            v.addError("Venda sem computador não permitida.", "computer", "sale.invalid.computer");
        }

        if (object.getOpenDate() == null) {
            if (action == ServiceAction.SAVE) {
                object.setOpenDate(new Date());
            } else {
                v.addError("Data de abertura de venda inválida, contate suporte", "openDate", "sale.error.opendate");
            }
        }
        
        if(object.isClosed() && action.equals(ServiceAction.UPDATE)){
            v.addError("Esta venda já foi fechada.", "closed", "sale.error.already.closed");
        }

        if (!v.isEmpty()) {
            throw v;
        }

        // Calcula o total
        Float total = 0f;

        for (SaleProduct p : object.getProducts()) {
            p.setTotal(p.getQuantity() * p.getSellPrice());
            total += p.getTotal();
        }

        object.setTotal(total);

    }

    public Sale loadSale(Computer computer) throws Exception {

        Sale s;

        try {
            s = dao.getActive(computer);

            calculateTotal(s);

        } catch (NoResultException ex) {
            s = new Sale();
            s.setOpenDate(new Date());
            s.setProducts(new ArrayList<SaleProduct>());
            s.setComputer(computer);
            s.setTotal(0f);
            save(s);
        }

        return s;
    }

    public void calculateTotal(Sale s) {
        
        Float total = 0f;

        for (SaleProduct p : s.getProducts()) {
            p.setTotal(p.getQuantity() * p.getSellPrice());
            total += p.getTotal();
        }

        s.setTotal(total);
       
    }
    
    /**
     * Usado para setar um novo total para a venda.
     * Caso esse total esteja abaixo do disconto máximo.
     * @param sale
     * @param total
     * @throws OutOfDiscountException 
     */
    public void checkTotal(Sale sale, float total) throws OutOfDiscountException{
         
        // Calcula o valor de desconto máximo
        float minSaleValue = 0f;
        
        
        if (sale.getProducts() != null) {

            for (SaleProduct p : sale.getProducts()) {
                /**
                 * calcula primeiramente o valor mínimo do produto, depois
                 * calcula multiplica pelo número de produtos e soma com o
                 * total.
                 */
                final float minSellValue = p.getSellPrice() - (p.getSellPrice()
                        * p.getProduct().getMaxDiscountPercent().floatValue() / 100);
                minSaleValue += minSellValue * p.getQuantity();
            }
        }
        
        if (total < minSaleValue) {
            calculateTotal(sale);
            final float currentTotal = sale.getTotal();
            OutOfDiscountException ex = new OutOfDiscountException("Out of discount!");
            ex.setMinValue(minSaleValue);
            ex.setMaxDiscountPercent(Float.valueOf(100 - minSaleValue/currentTotal*100f).intValue());
            ex.setCurrentDiscoutPercent(Float.valueOf(100 - total/currentTotal*100f).intValue());
            throw ex;
        }
        
    }

    public void closeSale(Sale sale) throws Exception {
        checkTotal(sale, sale.getTotal());
        validate(sale, ServiceAction.UPDATE);
        sale.setCanceled(false);
        sale.setCloseDate(new Date());
        sale.setClosed(true);
        update(sale, true);
    }
}
