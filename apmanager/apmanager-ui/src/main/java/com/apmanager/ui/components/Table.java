/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.components;

import com.apmanager.domain.entity.Entity;
import com.apmanager.ui.components.table.CellRender;
import com.towel.swing.table.ObjectTableModel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class Table<T extends Entity> extends javax.swing.JTable {

    public Table() {
        
        super();
        final CellRender render = new CellRender();
        setDefaultRenderer(String.class, render);
        setDefaultRenderer(Integer.class, render);
        setDefaultRenderer(Float.class, render);
        setDefaultRenderer(Double.class, render);
        setDefaultRenderer(Long.class, render);
        
        setRowHeight(25);

        JTableHeader t = getTableHeader();
        t.setFont(new java.awt.Font("Arial", 1, 14));
        t.setPreferredSize(new Dimension(100, 35));
        t.setMinimumSize(new Dimension(20, 35));

        t.setEnabled(false);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) t.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        this.getTableHeader().setFocusable(false);
        
    }

    public List<T> getSelecteds() {
        int[] selectedsIndex = getSelectedRows();
        TableModel model = getModel();

        if (model instanceof ObjectTableModel) {
            ObjectTableModel model1 = (ObjectTableModel) model;
            return model1.getList(selectedsIndex);
        }
        throw new IllegalStateException(
                "Not implemented to another table model, only to ObjectTableModel.");
    }

    public T getSelected() {
        int selectedIndex = getSelectedRow();
        TableModel model = getModel();

        if (selectedIndex != -1) {
            if (model instanceof ObjectTableModel) {
                ObjectTableModel model1 = (ObjectTableModel) model;
                return (T) model1.getData().get(selectedIndex);
            }
        } else {
            return null;
        }
        throw new IllegalStateException(
                "Not implemented to another table model, only to ObjectTableModel.");
    }
}
