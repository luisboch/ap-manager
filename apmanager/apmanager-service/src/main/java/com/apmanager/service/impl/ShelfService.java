package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.ShelfDAO;
import com.apmanager.domain.entity.ProductBrand;
import com.apmanager.domain.entity.Shelf;
import com.apmanager.service.BasicService;
import com.apmanager.service.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class ShelfService extends BasicService<Shelf, ShelfDAO> {

    private static final Logger log = LoggerFactory.getLogger(ShelfService.class);

    public ShelfService() {
        this.dao = new ShelfDAO(emanager);
    }

    @Override
    public void validate(Shelf object) throws ValidationException {
        ValidationException e = new ValidationException(ProductBrand.class);
        if(object.getCode() == null || object.getCode().equals("")){
            e.addError("Código inválido", "code", "invalid.code");
        }
        if(!e.isEmpty()){
            throw e;
        }
    }
}
