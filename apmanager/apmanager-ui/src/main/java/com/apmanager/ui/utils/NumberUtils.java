/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.utils;

import java.text.DecimalFormat;

/**
 *
 * @author luis
 */
public class NumberUtils {

    public static String toString(Float value) {

        if (value == null) {
            return null;
        }

        DecimalFormat df = new DecimalFormat("#0.00");
        String nValue = df.format(value).replace(".", ",");

        return nValue;
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
}
