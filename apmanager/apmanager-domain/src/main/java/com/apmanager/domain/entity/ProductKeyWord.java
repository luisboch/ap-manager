/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "produto_palavras_chave")
public class ProductKeyWord implements Serializable {

    @Id
    @SequenceGenerator(name = "product-keyword-seq", sequenceName = "produto_palavras_chave_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "product-keyword-seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Product product;

    @Column(name = "palavra")
    private String keyWord;

    public ProductKeyWord() {
    }

    public ProductKeyWord(Product product, String keyWord) {
        this.product = product;
        this.keyWord = keyWord;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.product);
        hash = 79 * hash + Objects.hashCode(this.keyWord);
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
        final ProductKeyWord other = (ProductKeyWord) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.keyWord, other.keyWord)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductKeyWord{" + "product=" + product + ", keyWord=" + keyWord + '}';
    }
}
