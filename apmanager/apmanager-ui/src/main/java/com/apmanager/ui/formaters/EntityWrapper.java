/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.formaters;

import com.apmanager.domain.entity.Entity;
import java.util.Objects;

/**
 *
 * @author luis
 */
public class EntityWrapper<T extends Entity>{

    private T entity;
    private boolean fakeWrapper = false;
    
    
    public EntityWrapper(T entity) {
        if (entity ==  null){
            throw new IllegalArgumentException("Entity can't be null");
        }
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }
    
    @Override
    public String toString() {
        if(!fakeWrapper){
            return entity.getDisplayName();
        } else {
            return "-- Selecione --";
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.entity);
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
        final EntityWrapper other = (EntityWrapper) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        return true;
    }
    
    public static <T extends Entity> EntityWrapper<T> createEmpty(Class<T> clazz) 
            throws InstantiationException, IllegalAccessException{
        T instance = clazz.newInstance();
        EntityWrapper<T> wrapper = new EntityWrapper<>(instance);
        wrapper.fakeWrapper = true;
        return wrapper;
    }
    
    public boolean isFake(){
        return fakeWrapper;
    }
}
