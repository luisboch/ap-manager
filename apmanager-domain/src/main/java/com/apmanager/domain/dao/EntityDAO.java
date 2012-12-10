package com.apmanager.domain.dao;

import com.apmanager.domain.entity.Entity;
import java.util.List;

/**
 *
 * @author luis
 */
public interface EntityDAO<T extends Entity>{
    List<T> search(String search);
    void save(T object);
    void update(T object);
    void delete(T object);
}
