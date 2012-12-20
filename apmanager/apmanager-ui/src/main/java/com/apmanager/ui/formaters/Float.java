package com.apmanager.ui.formaters;

import com.towel.bean.Formatter;

/**
 *
 * @author ADMIN
 */
public class Float  implements Formatter {
    private SeparatorChar separatorChar;

    public Float() {
        this(SeparatorChar.COMMA);
    }
    
    public Float(SeparatorChar separatorChar) {
        this.separatorChar = separatorChar;
    }
    
    
    @Override
    public String format(Object obj) {
        char s = separatorChar.separator;
        String value = ""+(obj == null?"0"+s+"0":(obj+""));
        if(separatorChar.equals(SeparatorChar.COMMA)){
            value = value.replace(".", ",");
        }
        
        return value;
    }

    @Override
    public String getName() {
        return "calendar";
    }

    @Override
    public Object parse(Object s) {
        String o = (String) s;
        
        if(separatorChar.equals(SeparatorChar.COMMA)){
            o = o.replace(",", ".");
        }
        
        return java.lang.Float.valueOf(o);
    }
    
    public enum SeparatorChar{
        COMMA(','), 
        POINT('.');
        private char separator;

        private SeparatorChar(char separator) {
            this.separator = separator;
        }

        public char getSeparator() {
            return separator;
        }
        
    }
}
