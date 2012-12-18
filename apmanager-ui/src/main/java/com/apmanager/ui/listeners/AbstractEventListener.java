/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public abstract class AbstractEventListener {

    protected Component parent;
    private static final Logger log =
            LoggerFactory.getLogger(AbstractEventListener.class);

    public AbstractEventListener(Component parent) {
        this.parent = parent;
    }

    public void onError(java.awt.AWTEvent evt, Throwable e) {
        log.error(e.getMessage(), e);
        JOptionPane.showMessageDialog(parent,
                "Ops, encontramos um erro, por favor, contate o suporte!");

    }
}
