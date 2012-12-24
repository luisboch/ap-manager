/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.boch
 * @since Nov 7, 2012
 */
public class ActionListener extends AbstractEventListener
        implements java.awt.event.ActionListener {

    public ActionListener(Component parent) {
        super(parent);
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        parent.setEnabled(false);
        try {
            onActionPerformed(e);
        }catch (Throwable ex) {
            onError(e, ex);
        }
        parent.setEnabled(true);
    }

    public void onActionPerformed(ActionEvent e) throws Exception {
    }
}
