/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.utils;

import com.apmanager.domain.entity.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class DAOUtils {

    public static <P extends Entity> List<Serializable> toList(
            List<P> entities) {
        return toList(entities, false);
    }

    public static <P extends Entity> List<Serializable> toList(
            List<P> entities, boolean ignoreNull) {

        List<Serializable> ids = new ArrayList<>();
        for (P e : entities) {
            if (e.getId() != null || ignoreNull) {
                ids.add(e.getId());
            }
        }

        return ids;
    }
}
