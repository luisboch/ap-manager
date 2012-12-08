/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.main;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.ui.menu.Application;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        final Map<String, Object> map = getOptions(args);
        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    
                    JDialogSplash splash;
                    if((Boolean)map.get("force-background")){
                        splash = new JDialogSplash(null, true);
                    } else {
                        splash = new JDialogSplash(null, false);
                    }
                    splash.setVisible(true);
                    splash.setMessage("Iniciando Banco de Dados...", 15);
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
                    EntityManager em = emf.createEntityManager();
                    GenericDAO dao = new GenericDAO(em);
                    splash.setMessage("Aplicando alterações...", 60);
                    Application app = Application.getInstance();
                    splash.setMessage("Concluindo...", 95);

                    Thread.sleep(2000);
                    splash.setMessage("...Pronto", 100);
                    splash.setVisible(false);
                    app.setVisible(true);
                } catch (Exception e) {
                    Logger.getLogger("Main").log(Level.SEVERE, e.getMessage(), e);
                    JOptionPane.showMessageDialog(null,
                            "Error while loading application, see logs for more informations.");
                    System.exit(0);
                }
            }
        });
        r.start();

    }

    private static Map<String, Object> getOptions(String[] args) {
        Map<String, Object> map = new HashMap<>();

        for(int i = 0; i < args.length;i++){
            String key = args[i];
            if(key.startsWith("-")){
                if(args.length > i+1 && !args[i+1].startsWith("-")){
                    Object value;
                    if(args[i+1].equals("true")){
                        value = true;
                    } else if(args[i+1].equals("false")){
                        value = false;
                    } else {
                        value = args[i+1];
                    }
                    map.put(key.substring(1), value);
                } else {
                    map.put(key.substring(1), true);
                }
            }
        }
        
        return map;
    }
}
