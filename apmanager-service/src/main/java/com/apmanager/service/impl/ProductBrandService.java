package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.ProductBrandDAO;
import com.apmanager.domain.entity.ProductBrand;
import com.apmanager.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class ProductBrandService extends BasicService<ProductBrand> {

    private static final Logger log = LoggerFactory.getLogger(ProductBrandService.class);

    public ProductBrandService() {
        this.dao = new ProductBrandDAO(emanager);
    }
}
