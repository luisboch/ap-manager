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
    void setId(Serializable id);
}
