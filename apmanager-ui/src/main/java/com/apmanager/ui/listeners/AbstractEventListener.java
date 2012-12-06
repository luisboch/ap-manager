/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public abstract class AbstractEventListener {

    protected Component parent;
    private static final Logger log =
            Logger.getLogger(AbstractEventListener.class.getSimpleName());

    public AbstractEventListener(Component parent) {
        this.parent = parent;
    }

    public void onError(java.awt.AWTEvent evt, Throwable e) {
        log.log(Level.SEVERE, e.getMessage(), e);
        JOptionPane.showMessageDialog(parent,
                "Ops, encontramos um erro, por favor, contate o suporte!");

    }
}
