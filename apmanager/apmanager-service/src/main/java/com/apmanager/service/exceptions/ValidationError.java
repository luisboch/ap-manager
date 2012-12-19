/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.exceptions;

/**
 *
 * @author luis
 */

public class ValidationError {

    private String field;
    private String error;
    private Class classFor;
    private String i18n;

    public ValidationError(String field, String error, Class classFor,
            String i18n) {
        this.field = field;
        this.error = error;
        this.classFor = classFor;
        this.i18n = i18n;
    }

    public ValidationError(String error) {
        this.error = error;
    }

    public Class getClassFor() {
        return classFor;
    }

    
    public String getI18n() {
        return i18n;
    }
    
    public String getError() {
        return error;
    }

    public String getField() {
        return field;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ValidationError other = (ValidationError) obj;
        if (this.classFor != other.classFor && (this.classFor == null || 
                !this.classFor.equals(other.classFor))) {
            return false;
        }
        if ((this.i18n == null) ? (other.i18n != null) : 
                !this.i18n.equals(other.i18n)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.classFor != null ? this.classFor.hashCode() : 0);
        hash = 61 * hash + (this.i18n != null ? this.i18n.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ValidationError{" + "error=" + error + ", classFor=" +
                classFor + '}';
    }
    
}
