/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.formaters;

import com.towel.bean.Formatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DateFormatter implements Formatter {

    private final static SimpleDateFormat formatter = new SimpleDateFormat(
            "dd/MM/yyyy");

    @Override
    public String format(Object obj) {
        Date cal = (Date) obj;
        if(obj==null){
            return "";
        }
        return formatter.format(cal);
    }

    @Override
    public String getName() {
        return "calendar";
    }

    @Override
    public Object parse(Object o) {
        Date d = null;
        try {
            d = formatter.parse((String) o);
        } catch (ParseException ex) {
            Logger.getLogger(DateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return d;
    }
}