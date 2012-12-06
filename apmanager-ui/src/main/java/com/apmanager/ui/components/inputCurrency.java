/*
 * inputCurrency
*/

package com.apmanager.ui.components;

import javax.swing.text.Document;

/**
 *
 * @author luis
 */
public class inputCurrency <N extends Number> extends javax.swing.JTextField{

    public inputCurrency() {
    }

    public inputCurrency(String text) {
        super(text);
    }

    public inputCurrency(int columns) {
        super(columns);
    }

    public inputCurrency(String text, int columns) {
        super(text, columns);
    }

    public inputCurrency(Document doc, String text, int columns) {
        super(doc, text, columns);
    }

    @Override
    public void setText(String t) {
        t = t.replace(",", "").replace(".", ",");
        super.setText(t);
    }
    
    public void setValue(N number){
        
    }
}
