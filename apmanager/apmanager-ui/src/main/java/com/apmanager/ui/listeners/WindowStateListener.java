/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.awt.event.WindowEvent;

/**
 *
 * @author luis
 */
public abstract class WindowStateListener extends AbstractEventListener implements java.awt.event.WindowStateListener {

    public WindowStateListener(Component parent) {
        super(parent);
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        try {
            onWindowStateChanged(e);
        } catch (Throwable ex) {
            onError(e, ex);
        }
    }

    protected abstract void onWindowStateChanged(WindowEvent e);
}
