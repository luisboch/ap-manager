/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.formaters;

import com.apmanager.domain.entity.Entity;
import com.towel.bean.Formatter;

/**
 *
 * @author luis
 */
public class EntityFormatter<T extends Entity> implements Formatter {

    @Override
    public Object format(Object obj) {
        T p = (T) obj;
        if (p == null) {//No combo box o primeiro item sempre é null, para poder ficar em branco
            return "";
        }
        return p.getDisplayName();
    }

    @Override
    public Object parse(Object s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return "VehicleBrand";
    }
    
}
