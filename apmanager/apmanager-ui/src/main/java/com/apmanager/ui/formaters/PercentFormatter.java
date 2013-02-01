package com.apmanager.ui.formaters;

import com.apmanager.domain.utils.NumberUtils;
import com.towel.bean.Formatter;

/**
 *
 * @author ADMIN
 */
public class PercentFormatter  implements Formatter {
    
    @Override
    public String format(Object obj) {
        return ""+(obj == null?"0,00 %":NumberUtils.formatPercent((java.lang.Float)obj));
    }

    @Override
    public String getName() {
        return "calendar";
    }

    @Override
    public Object parse(Object s) {
        String o = (String) s;
        o = o.replace(" %", "");
        o = o.replace(",", ".");
        return java.lang.Float.valueOf(o);
    }
    
}
