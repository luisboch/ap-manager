/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.components;

import com.apmanager.ui.components.table.CellRender;
import java.awt.Dimension;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author ADMIN
 */
public class Table extends javax.swing.JTable {

    public Table() {

        super();
        setDefaultRenderer(String.class, new CellRender());
        setDefaultRenderer(Integer.class, new CellRender());
        setDefaultRenderer(Float.class, new CellRender());
        setDefaultRenderer(Double.class, new CellRender());
        setDefaultRenderer(Long.class, new CellRender());
        Enumeration<TableColumn> columns = getColumnModel().getColumns();

        setRowHeight(30);

        JTableHeader t = getTableHeader();
        t.setFont(new java.awt.Font("Arial", 1, 14));
        t.setPreferredSize(new Dimension(100, 35));
        t.setMinimumSize(new Dimension(20, 35));

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) t.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);


    }
}
