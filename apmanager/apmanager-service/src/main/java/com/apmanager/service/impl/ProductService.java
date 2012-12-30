/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.ProductDAO;
import com.apmanager.domain.entity.Product;
import com.apmanager.service.BasicService;
import com.apmanager.service.exceptions.ValidationException;

/**
 *
 * @author luis
 */
public class ProductService extends BasicService<Product, ProductDAO> {

    public ProductService() {
        this.dao = new ProductDAO(emanager);
    }

    @Override
    public void validate(Product object) throws ValidationException {
        ValidationException v = new ValidationException();


        if (object.getName() == null || object.getName().equals("")) {
            v.addError("Nome do produto inválido", "brand",
                    "invalid.product.name");
        }

        if (object.getBrand() == null) {
            v.addError("Seleciona a marca do produto", "brand",
                    "invalid.product.brand");
        }

        if (object.getShelf() == null) {
            v.addError("Prateleira do produto inválida", "shelf",
                    "invalid.product.shelf");
        }

        if (object.getMinQuantity() == null || object.getMinQuantity().intValue() < 0) {
            v.addError("Quantidade minima do produto inválida", "minQuantity",
                    "invalid.product.min.quantity");
        }

        if (object.getQuantity() == null) {
            v.addError("Quantidade do produto inválida", "quantity",
                    "invalid.product.quantity");
        }

        if (object.getSellPrice() == null || object.getSellPrice().floatValue() < 0) {
            v.addError("Preço de venda do produto inválido", "sellPrice",
                    "invalid.product.sell.price");
        }

        if (object.getPurchuasePrice() == null || object.getPurchuasePrice().floatValue() < 0) {
            v.addError("Preço de Compra do produto inválido", "purchuasePrice",
                    "invalid.product.purchuase.price");
        }

        if (object.getMaxDiscountPercent() == null) {
            v.addError("Desconto máximo inválido", "maxDiscountPercent",
                    "invalid.product.discount.percent");
        }

        if (!v.isEmpty()) {
            throw v;
        }
    }

    public synchronized void generateNewCode(Product product) throws Exception {
        if (product.getAdditionalCode() != null && 
                !product.getAdditionalCode().equals("")) {
            final ValidationException ex = new ValidationException();
            ex.addError("Este produto já possui código adicional",
                    "additionalCode", "product.have.additional.code");
            throw ex;
        }
        String code = this.dao.getNextValidCode();
        product.setAdditionalCode(code);
        this.save(product);
    }
}
