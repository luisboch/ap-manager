/*
 * Entity
*/

package com.apmanager.domain.entity;

import java.io.Serializable;

/**
 *
 * @author luis
 */
public interface Entity extends Serializable{
    Serializable getId();
    public String getDisplayName();
    void setId(Serializable id);
    void setStatus(boolean newStatus);
    boolean isActive();
}
