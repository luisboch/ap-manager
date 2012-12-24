/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.menu;

import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ADMIN
 */
public class JDialogLoading extends javax.swing.JDialog {

    private static final Logger log = LoggerFactory.getLogger(JDialogLoading.class);
    private Runnable run;

    /**
     * Creates new form JDialogLoading
     */
    public JDialogLoading(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setText("Carregando...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void action(Runnable run) {
        this.run = run;
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            if (run != null) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            run.run();
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                            JOptionPane.showMessageDialog(getParent(),
                                    "Ops, encontramos um erro, por favor, contate o suporte!");
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            log.error(ex.getMessage(), ex);
                        }
                        setVisible(false);
                    }
                });
                t.start();
            }
        }
        super.setVisible(b);
    }
}