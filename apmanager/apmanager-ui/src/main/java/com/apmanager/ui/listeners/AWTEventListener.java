package com.apmanager.ui.listeners;

import java.awt.AWTEvent;
import java.awt.Component;

/**
 *
 * @author luis
 */
public abstract class AWTEventListener extends AbstractEventListener implements java.awt.event.AWTEventListener {

    public AWTEventListener(Component parent) {
        super(parent);
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        try {
            onEventDispatched(event);

        } catch (Throwable ex) {
            onError(event, ex);
        }
    }

    protected abstract void onEventDispatched(AWTEvent event);
}
