package com.apmanager.ui.formaters;

import com.towel.bean.Formatter;

/**
 *
 * @author ADMIN
 */
public class Currency  implements Formatter {
    
    @Override
    public String format(Object obj) {
        return ""+(obj == null?"0,00":(obj+"").replace(".", ","));
    }

    @Override
    public String getName() {
        return "calendar";
    }

    @Override
    public Object parse(Object s) {
        String o = (String) s;
        o = o.replace("RS ", "");
        o = o.replace(",", ".");
        return java.lang.Float.valueOf(o);
    }
    
}
