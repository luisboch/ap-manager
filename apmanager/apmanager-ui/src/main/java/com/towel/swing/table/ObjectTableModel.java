package com.towel.swing.table;

import com.towel.el.FieldResolver;
import com.towel.el.annotation.AnnotationResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A TableModel based on reflection.
 *
 * @author Marcos Vasconcelos
 */
public class ObjectTableModel<T> extends AbstractTableModel {
    private static final Logger log = LoggerFactory.getLogger(ObjectTableModel.class);
    private List<T> data;

    private FieldResolver fields[];

    private boolean editDefault;

    private Boolean editableCol[];

    public ObjectTableModel(AnnotationResolver resolver, String cols) {
        data = new ArrayList<>();
        this.fields = (FieldResolver[]) resolver.resolve(cols).clone();
        editDefault = false;
        editableCol = new Boolean[fields.length];
    }

    public ObjectTableModel(FieldResolver fields[]) {
        data = new ArrayList<>();
        this.fields = (FieldResolver[]) fields.clone();
        editDefault = false;
        editableCol = new Boolean[this.fields.length];
    }

    public void setEditableDefault(boolean editable) {
        editDefault = editable;
    }

    public void setColEditable(int col, boolean editable) {
        editableCol[col] = editable;
    }

    @Override
    public boolean isCellEditable(int i, int k) {
        if (editableCol == null || editableCol[k] == null) {
            return editDefault;
        }
        return editableCol[k];
    }

    @Override
    public int getColumnCount() {
        return fields.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Object obj = data.get(rowIndex);
            Object obj2 = fields[columnIndex].getValue(obj);
            return obj2;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void setValueAt(Object value, int arg0, int arg1) {
        try {
            Object obj = data.get(arg0);
            fields[arg1].setValue(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getValue(int arg0) {
        return data.get(arg0);
    }

    @Override
    public String getColumnName(int row) {
        return fields[row].getName();
    }

    public void add(T obj) {
        data.add(obj);
        fireTableDataChanged();
    }

    public void clear() {
        data = new ArrayList<>();
        fireTableDataChanged();
    }

    public void setData(List<T> data) {
        this.data = data;
        fireTableDataChanged();
    }

    public void remove(int row) {
        data.remove(row);
        fireTableDataChanged();
    }

    public List<T> getData() {
        return new ArrayList<>(data);
    }

    public void remove(int idx[]) {
        for (int i : idx) {
            remove(i);
        }
    }

    public void remove(List<T> objs) {
        for (T t : objs) {
            remove(indexOf(t));
        }
    }

    public void remove(T obj) {
        remove(indexOf(obj));
    }

    public void addAll(Collection<T> coll) {
        for (T t : coll) {
            add(t);
        }
    }

    public List<T> getList(int idx[]) {
        List<T> list = new ArrayList<>();
        int size = idx.length;
        for (int j = 0; j < size; j++) {
            list.add(getValue(idx[j]));
        }

        return list;
    }

    public int indexOf(T obj) {
        return data.indexOf(obj);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public FieldResolver getColumnResolver(int colIndex) {
        return fields[colIndex];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return getColumnResolver(col).getFieldType();
    }

    public void setEditableCol(Boolean[] editableCol) {
        this.editableCol = editableCol;
    }
}