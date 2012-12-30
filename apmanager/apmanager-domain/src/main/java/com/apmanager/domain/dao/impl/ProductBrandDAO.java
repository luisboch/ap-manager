package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.ProductBrand;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class ProductBrandDAO extends GenericDAO<ProductBrand> {

    public ProductBrandDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<ProductBrand> search(String search) {
        search = search == null ? "" : search;
        List<ProductBrand> results = null;

        String sql = "select pb from ProductBrand pb "
                + "where pb.status = true and (lower(pb.name) like lower(:search) or lower(pb.description) like lower(:search))"
                + "order by pb.name";
        Query q = em.createQuery(sql);

        q.setParameter("search", "%".concat(search).concat("%"));

        results = q.getResultList();

        return results;
    }

    @Override
    public void save(ProductBrand object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
    
    
}
