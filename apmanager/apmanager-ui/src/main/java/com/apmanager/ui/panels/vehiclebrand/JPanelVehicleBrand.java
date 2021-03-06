
package com.apmanager.ui.panels.vehiclebrand;

import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.service.impl.VehicleBrandService;
import com.apmanager.ui.components.Button;
import com.apmanager.ui.components.Table;
import com.apmanager.ui.listeners.ActionListener;
import com.apmanager.ui.listeners.KeyListener;
import com.apmanager.ui.listeners.MouseListener;
import com.apmanager.ui.menu.Application;
import com.apmanager.ui.panels.AbstractAdminPanel;
import com.apmanager.ui.panels.AdminPanel;
import com.towel.el.FieldResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author luis
 */
public class JPanelVehicleBrand extends AbstractAdminPanel<VehicleBrand, VehicleBrandService> implements AdminPanel {

    JDialogVehicleBrandEdit dialog;

    /**
     * Creates new form JPanelVehicleBrand
     */
    public JPanelVehicleBrand() {
        super();
        initComponents();
        addListeners();
        dialog = new JDialogVehicleBrandEdit(Application.getInstance(), true);
        final VehicleBrandService vehicleBrandService = new VehicleBrandService();
        service= vehicleBrandService;
        dialog.setService(vehicleBrandService);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonSearch = new Button(this, KeyEvent.VK_F5);
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResults = new Table();
        jPanel2 = new javax.swing.JPanel();
        jButtonDelete = new Button(this, KeyEvent.VK_DELETE);
        jButtonEdit = new Button(this, KeyEvent.VK_F7);
        jButtonNew = new Button(this, KeyEvent.VK_F6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisar"));

        jButtonSearch.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearch)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jTableResults);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Administrar"));

        jButtonDelete.setText("Excluir");

        jButtonEdit.setText("Alterar");

        jButtonNew.setText("Novo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonNew))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableResults;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadContent() {

        if (results != null) {
            results.clear();
        } else {
            results = new ArrayList<>();
        }
        
        populateResults();
        dialog.clear();
    }

    private void addListeners() {
        final JPanel panel = this;
        jButtonSearch.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                search();
            }
        });

        jButtonEdit.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {

                int selectedRow = jTableResults.getSelectedRow();
                if (selectedRow != -1) {
                    panel.setEnabled(false);
                    VehicleBrand brand = model.getValue(selectedRow);
                    dialog.setInstance(brand);
                    dialog.setVisible(true);
                    panel.setEnabled(true);
                    jButtonSearch.doClick();
                }
            }
        });

        jButtonNew.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                panel.setEnabled(false);
                dialog.setInstance(new VehicleBrand());
                dialog.setVisible(true);
                panel.setEnabled(true);
                jButtonSearch.doClick();
            }
        });

        jButtonDelete.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                panel.setEnabled(false);


                List<VehicleBrand> entitys;
                try {
                    final int[] selectedRows = jTableResults.getSelectedRows();
                    entitys = model.getList(selectedRows);
                } catch (NullPointerException ex) {
                    entitys = null;
                }

                delete(entitys);
                panel.setEnabled(true);

            }
        });

        jTableResults.addMouseListener(new MouseListener(this) {
            @Override
            public void onMouseRelease(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    final int selectedRow = jTableResults.getSelectedRow();
                    if (selectedRow != -1) {
                        panel.setEnabled(false);
                        VehicleBrand brand = model.getValue(selectedRow);
                        dialog.setInstance(brand);
                        dialog.setVisible(true);
                        panel.setEnabled(true);
                        jButtonSearch.doClick();
                    }

                }
            }
        });
        jTextFieldSearch.addKeyListener(new KeyListener(this){

            @Override
            public void onKeyRelease(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    jButtonSearch.doClick();
                }
            }
            
        });
    }

    @Override
    protected void populateResults() {

        FieldResolver idResolver = new FieldResolver(VehicleBrand.class, "id", "Código");
        FieldResolver nameResolver = new FieldResolver(VehicleBrand.class, "name", "Nome");

        model = new ObjectTableModel<>(
                new FieldResolver[]{idResolver, nameResolver});

        model.setData(results);

        jTableResults.setModel(model);
    }

    @Override
    protected void search() {
        search(jTextFieldSearch.getText());
    }

    @Override
    public void unloadContent() {
    
    }
}
