/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.components.table;

import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author luis
 */
public interface CellRenderListener {
    Color getBackgroundColor(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int column);
}
