package com.apmanager.ui.main;

import java.awt.Color;

/**
 *
 * @author luis
 */
public class JDialogSplash extends javax.swing.JDialog {

    /**
     * Creates new form JDialogSplash
     */
    public JDialogSplash(java.awt.Frame parent, boolean forceBackground) {
        super(parent, false);
        initComponents();
        setLocationRelativeTo(null);

        // Transparent BG
        getRootPane().setOpaque(false);
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        if (!forceBackground) {
            setBackground(new Color(0, 0, 0, 0));
        }
        setSize(400, 120);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("APManager");
        setMaximumSize(new java.awt.Dimension(400, 120));
        setMinimumSize(new java.awt.Dimension(400, 120));
        setUndecorated(true);
        setResizable(false);

        jProgressBar1.setForeground(new java.awt.Color(82, 143, 201));

        jLabelMessage.setBackground(new java.awt.Color(0, 153, 51));
        jLabelMessage.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(102, 102, 102));
        jLabelMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMessage.setText("Loading...");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autopecas/images/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public void setMessage(String message, int percent) {
        jLabelMessage.setText(message);
        jProgressBar1.setValue(percent);
    }
}
