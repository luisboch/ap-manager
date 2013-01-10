/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.SaleDAO;
import com.apmanager.domain.entity.Computer;
import com.apmanager.domain.entity.Sale;
import com.apmanager.domain.entity.SaleProduct;
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

        if (!v.isEmpty()) {
            throw v;
        }
    }

    public Sale loadSale(Computer computer) throws Exception {
        
        Sale s;

        try {
            s = dao.getActive(computer);
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
}
