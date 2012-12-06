/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.menu;

import com.apmanager.ui.menu.enums.WindowType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class JMenuDinamic extends JMenuItem implements ActionListener{

    private WindowType type;
    private JPanel panel;
    private Application app;

    public JMenuDinamic(Application app, WindowType type) {
        this.app = app;
        this.type = type;
        configureListener();
    }
    
    public JPanel getPanel() {
        if(panel == null){
            try{
                panel = type.getDestined().newInstance();
            } catch (InstantiationException | IllegalAccessException e){
                Logger.getLogger(
                        this.getClass().getSimpleName()).
                        log(Level.SEVERE, e.getMessage(), e);
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
        
        if(app.getSelected() == null || !app.getSelected().equals(this)){
            app.setApplicationPanel(getPanel());
            app.setTitle(type.getTitle());
        }
        
        app.setSelected(this);
    }
}
