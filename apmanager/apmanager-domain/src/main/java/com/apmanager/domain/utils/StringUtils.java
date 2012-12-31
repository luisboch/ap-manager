/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.domain.utils;

import java.text.Normalizer;

/**
 *
 * @author luis
 */
public class StringUtils {

    public static String normalize(String param) {
        param = Normalizer.normalize(param, Normalizer.Form.NFD);
        param = param.replaceAll("[^\\p{ASCII}]", "");
        return param;
    }
}
