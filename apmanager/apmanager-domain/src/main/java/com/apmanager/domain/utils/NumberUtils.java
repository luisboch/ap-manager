/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.utils;

import java.text.DecimalFormat;

/**
 *
 * @author luis
 */
public class NumberUtils {
    public static String toString(Float value) {
        return toString(value, 2);
    }
    public static String toString(Float value, int decimalSize) {

        if (value == null) {
            return null;
        }
        String decimalFormat = "";
        for(int i = 0; i < decimalSize;i++){
            decimalFormat = decimalFormat.concat("0");
        }
        DecimalFormat df = new DecimalFormat("#0.".concat(decimalFormat));
        String nValue = df.format(value).replace(".", ",");

        return nValue;
    }
    
    
    public static String currency(Float value) {
        return "R$ "+ toString(value);
    }

    public static Float toFloat(String value) {

        if (value == null || value.equals("")) {
            return null;
        }

        String nValue = value.replace(",", ".");

        return Float.valueOf(nValue);
    }

    public static Integer toInteger(String value) {

        if (value == null || value.equals("")) {
            return null;
        }

        String nValue = value.replace(",", ".");
        try {
            return Integer.valueOf(nValue);
        } catch (NumberFormatException f) {
            return null;
        }
    }
    /**
     * Receive float number less than one and return formatted by percent
     * example: value: 0.10f return 10,00 %.
     * 
     * @param value need an value < 1
     * @return formatted value
     */
    public static String formatPercent(Float value){
        return toString(value*100) + " %";
    }
    
    /**
     * Receive float number less than one and return formatted by percent
     * example: value: 0.10f return 10,{@param decimalSize} %.
     * 
     * @param value need an value < 1
     * @return formatted value
     */
    public static String formatPercent(Float value, int decimalSize){
        return toString(value*100,decimalSize) + " %";
    }
}
