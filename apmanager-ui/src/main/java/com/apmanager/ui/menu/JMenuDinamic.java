/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.menu;

import com.apmanager.ui.menu.enums.WindowType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ADMIN
 */
public class JMenuDinamic extends JMenuItem implements ActionListener {

    private static final Logger log = LoggerFactory.getLogger(JMenuDinamic.class);
    private WindowType type;
    private JPanel panel;
    private Application app;

    public JMenuDinamic(Application app, WindowType type) {
        this.app = app;
        this.type = type;
        configureListener();
    }

    public JPanel getPanel() {
        if (panel == null) {
            try {
                panel = type.getDestined().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(app,
                        "Ops, encontramos um erro, por favor, contate o suporte!");
            }
        }
        return panel == null ? panel = new JPanel() : panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    private void configureListener() {
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (app.getSelected() == null || !app.getSelected().equals(this)) {
                app.setApplicationPanel(getPanel());
                app.setTitle(type.getTitle());
            }

            app.setSelected(this);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            JOptionPane.showMessageDialog(app,
                    "Ops, encontramos um erro, por favor, contate o suporte!");
        }
    }
}
