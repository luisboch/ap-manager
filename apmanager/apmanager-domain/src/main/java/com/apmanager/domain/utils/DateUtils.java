/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luis
 */
public class DateUtils {
    private static Calendar c;
    static{
        c = Calendar.getInstance();
    }
    
    public static Date toInitDay(Date d){
        c.setTime(d);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    public static Date toFinalDay(Date d){
        c.setTime(d);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
}
