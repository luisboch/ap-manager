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
import javax.swing.DefaultRowSorter;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ADMIN
 */
public class Table<T extends Entity> extends javax.swing.JTable {

    private static final Logger log = LoggerFactory.getLogger(Table.class);

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

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) t.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public List<T> getSelecteds() {
        int[] selectedsIndex = getSelectedRows();
        if (getModel() instanceof ObjectTableModel) {
            selectedsIndex = getRealModelIndexes(selectedsIndex);
            ObjectTableModel tableModel = (ObjectTableModel) getModel();
            return tableModel.getList(selectedsIndex);
        }
        throw new IllegalStateException(
                "Not implemented to another table model, only to ObjectTableModel.");
    }

    private int[] getRealModelIndexes(int[] indexes) {
        if (indexes != null) {

            int[] results = new int[indexes.length];
            
            for (int i = 0; i < indexes.length; i++) {
                results[i] = convertRowIndexToModel(indexes[i]);
            }

            return results;
        } else {
            return new int[0];
        }
    }

    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
        log.debug("Creating default table row order...");
        setAutoCreateRowSorter(true);
    }

    public T getSelected() {
        int selectedIndex = getSelectedRow();

        if (selectedIndex != -1) {

            selectedIndex = convertRowIndexToModel(selectedIndex);

            if (getModel() instanceof ObjectTableModel) {
                ObjectTableModel tableModel = (ObjectTableModel) getModel();
                return (T) tableModel.getData().get(selectedIndex);
            }
        } else {
            return null;
        }
        throw new IllegalStateException(
                "Not implemented to another table model, only to ObjectTableModel.");
    }

}
