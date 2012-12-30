/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.awt.event.ItemEvent;

/**
 *
 * @author luis
 */
public class ItemListener extends AbstractEventListener implements java.awt.event.ItemListener{

    public ItemListener(Component parent) {
        super(parent);
    }


    @Override
    public final void itemStateChanged(ItemEvent e) {
        parent.setEnabled(false);
        try {
            onItemStateChanged(e);
        }catch (Throwable ex) {
            onError(e, ex);
        }
        parent.setEnabled(true);
    
    }

    protected void onItemStateChanged(ItemEvent e) {
    }
    
}
