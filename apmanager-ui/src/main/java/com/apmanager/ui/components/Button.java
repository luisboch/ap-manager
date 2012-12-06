package com.apmanager.ui.components;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class Button extends JButton {

    private static final Logger log = Logger.getLogger(Button.class.getSimpleName());

    private Component parent;

    private int key;

    private boolean useKey = true;

    public Button(Component parent) {
        this.parent = parent;
        useKey = false;
        configure();

    }

    public Button(Component parent, int keyEventVk) {
        this.parent = parent;
        this.key = keyEventVk;
        configure();

    }

    public Button(Icon icon, Component parent, int keyEventVk) {
        super(icon);
        this.parent = parent;
        this.key = keyEventVk;
        configure();
    }

    public Button(String text, Component parent, int keyEventVk) {
        super(text);
        this.parent = parent;
        this.key = keyEventVk;
        configure();
    }

    public Button(Action a, Component parent, int keyEventVk) {
        super(a);
        this.parent = parent;
        this.key = keyEventVk;
        configure();
    }

    public Button(String text, Icon icon, JPanel parent, int keyEventVk) {
        super(text, icon);
        this.parent = parent;
        this.key = keyEventVk;
        configure();
    }

    private void configure() {
        setBackground(new java.awt.Color(153, 204, 255));
        setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        setForeground(new java.awt.Color(51, 51, 51));
        setMargin(new Insets(4, 10, 4, 10));
        if (useKey) {
            addListener();
        }
    }

    private void addListener() {
        final JButton jbutton = this;
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new AWTEventListener() {
                    @Override
                    public void eventDispatched(AWTEvent event) {
                        // Verifica se este painel está sendo exibido
                        if (jbutton.isVisible() && parent.isVisible() && parent.isEnabled()) {
                            KeyEvent ev = (KeyEvent) event;
                            // Verifica se foi um key Released
                            if (ev.getKeyCode() == key && ev.getID() == KeyEvent.KEY_RELEASED) {
                                log.info("Performing click");
                                jbutton.doClick();
                            }
                        }

                    }
                }, AWTEvent.KEY_EVENT_MASK);
    }

    @Override
    public void setText(String text) {
        StringBuilder b = new StringBuilder();
        if (useKey) {
            switch (key) {
                case KeyEvent.VK_F1:
                    b.append("F1 - ");
                    break;
                case KeyEvent.VK_F2:
                    b.append("F2 - ");
                    break;
                case KeyEvent.VK_F3:
                    b.append("F3 - ");
                    break;
                case KeyEvent.VK_F4:
                    b.append("F4 - ");
                    break;
                case KeyEvent.VK_F5:
                    b.append("F5 - ");
                    break;
                case KeyEvent.VK_F6:
                    b.append("F6 - ");
                    break;
                case KeyEvent.VK_F7:
                    b.append("F7 - ");
                    break;
                case KeyEvent.VK_F8:
                    b.append("F8 - ");
                    break;
                case KeyEvent.VK_F9:
                    b.append("F9 - ");
                    break;
                case KeyEvent.VK_F10:
                    b.append("F10 - ");
                    break;
                case KeyEvent.VK_F11:
                    b.append("F11 - ");
                    break;
                case KeyEvent.VK_F12:
                    b.append("F12 - ");
                    break;
                case KeyEvent.VK_DELETE:
                    b.append("DEL - ");
                    break;
            }
        }
        b.append(text);
        super.setText(b.toString());
    }
}
