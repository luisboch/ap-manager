/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ValidationException extends Exception {
    private List<ValidationError> _errors;
    private Class classFor;

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        init();
    }

    public ValidationException(Throwable cause) {
        super(cause);
        init();
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
        init();
    }

    public ValidationException(String message) {
        super(message);
        init();
    }

    public ValidationException() {
        init();
    }
    public ValidationException(Class classFor, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        init();
    }

    public ValidationException(Class classFor, Throwable cause) {
        super(cause);
        init();
    }

    public ValidationException(Class classFor, String message, Throwable cause) {
        super(message, cause);
        init();
    }

    public ValidationException(Class classFor, String message) {
        super(message);
        init();
    }

    public ValidationException(Class classFor) {
        init();
    }
    
    public void addError(String error){
        _errors.add(new ValidationError(error));
    }
    
    public void addError(String error,String field, String i18n){
        _errors.add(new ValidationError(field, error, classFor, i18n));
    }
    public void addError(String error,String field, Class classFor,String i18n){
        _errors.add(new ValidationError(field, error, classFor, i18n));
    }
    
    private void init() {
        _errors = new ArrayList<ValidationError>();
    }
    
    public boolean isEmpty(){
        return _errors.isEmpty();
    }
    
    public void remove(ValidationError error){
        _errors.remove(error);
    }
    
    public void clear(){
        _errors.clear();
    }
    
    public List<String> getErros(){
        List<String> es = new ArrayList<String>();
        for(ValidationError e:_errors){
            es.add(e.getError());
        }
        return es;
    }
    
    public List<ValidationError> getErrors(){
        return _errors;
    }

    public Class getClassFor() {
        return classFor;
    }

    public void setClassFor(Class classFor) {
        this.classFor = classFor;
    }
    
}
