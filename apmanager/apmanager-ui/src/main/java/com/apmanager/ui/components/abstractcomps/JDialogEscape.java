/*
 * JDialogEscape
 */
package com.apmanager.ui.components.abstractcomps;

import com.apmanager.ui.menu.JDialogSearchProduct;
import java.awt.AWTEvent;
import java.awt.Dialog;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author luis
 */
public class JDialogEscape extends JDialog {

    public JDialogEscape(Frame owner) {
        super(owner, true);
        configureListener();
    }

    public JDialogEscape() {
        configureListener();
    }

    public JDialogEscape(Dialog owner) {
        super(owner);
        configureListener();
    }

    public JDialogEscape(Window owner) {
        super(owner);
        configureListener();
    }

    public JDialogEscape(Dialog owner, String title) {
        super(owner, title);
        configureListener();
    }

    public JDialogEscape(Dialog owner, boolean modal) {
        super(owner, modal);
        configureListener();
    }

    public JDialogEscape(Frame owner, String title) {
        super(owner, title);
        configureListener();
    }

    public JDialogEscape(Frame owner, boolean modal) {
        super(owner, modal);
        configureListener();
    }

    public JDialogEscape(Window owner, ModalityType modalityType) {
        super(owner, modalityType);
        configureListener();
    }

    public JDialogEscape(Window owner, String title) {
        super(owner, title);
        configureListener();
    }

    public JDialogEscape(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
        configureListener();
    }

    public JDialogEscape(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        configureListener();
    }

    public JDialogEscape(Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
        configureListener();
    }

    public JDialogEscape(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
        configureListener();
    }

    public JDialogEscape(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
        configureListener();
    }

    public JDialogEscape(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, title, modalityType, gc);
        configureListener();
    }

    private void configureListener() {
        final JDialogEscape dialog = this;
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new AWTEventListener() {
                    @Override
                    public void eventDispatched(AWTEvent event) {
                        KeyEvent ev = (KeyEvent) event;
                        if (ev.getID() == KeyEvent.KEY_RELEASED
                                && ev.getKeyCode() == KeyEvent.VK_ESCAPE
                                && dialog.isVisible() && dialog.isEnabled()) {
                            dialog.onHide(ev);
                            dialog.setVisible(false);
                        }
                    }
                }, AWTEvent.KEY_EVENT_MASK);

    }
    protected void onHide(AWTEvent e){
    }
}
