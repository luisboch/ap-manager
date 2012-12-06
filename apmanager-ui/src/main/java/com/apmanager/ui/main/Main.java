/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.main;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.ui.menu.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                JDialogSplash splash = new JDialogSplash(null);
                splash.setVisible(true);
                splash.setMessage("Iniciando Banco de Dados...", 15);
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
                EntityManager em = emf.createEntityManager();
                GenericDAO dao = new GenericDAO(em);
                splash.setMessage("Aplicando alterações...", 60);
                Application app = Application.getInstance();
                splash.setMessage("Concluindo...", 95);
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                splash.setMessage("...Pronto", 100);
                splash.setVisible(false);
                app.setVisible(true);
            }
        });
        r.start();

    }
}
