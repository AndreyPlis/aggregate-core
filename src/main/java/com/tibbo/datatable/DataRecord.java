package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord implements Cloneable {

    private TableFormat tableFormat;

    private Map<String, Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void setValue(String fieldName, Object value) {
        FieldFormat ff = tableFormat.getField(fieldName);
        if (ff == null)
            throw new IllegalStateException("Field cannot find: " + fieldName);
        setData(ff, value);
    }

    public void setValue(int index, Object value) {
        FieldFormat ff = findField(index);
        if (ff == null)
            throw new IllegalStateException("Field cannot find: " + index);
        setData(findField(index), value);
    }

    private void setData(FieldFormat ff, Object value) {
        ff.validate(value);
        data.put(ff.getName(), value);
    }

    public Object getValue(int index) {
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName) {
        return data.get(fieldName);
    }

    private FieldFormat findField(int index) {
        return tableFormat.getField(index);
    }

    @Override
    public DataRecord clone() {
        try {
            DataRecord clone = (DataRecord) super.clone();
            clone.tableFormat = tableFormat.clone();
            clone.data = new HashMap<>(data);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }
}
