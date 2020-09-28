package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord implements Cloneable {

    private TableFormat tableFormat;

    private Map<String, Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public <T extends Comparable<T>> void setValue(String fieldName, Object value) {
        FieldFormat<T> ff = tableFormat.getField(fieldName);
        if (ff == null)
            throw new IllegalStateException("Field cannot find: " + fieldName);
        setData(ff, value);
    }

    public <T extends Comparable<T>> void setValue(int index, Object value) {
        FieldFormat<T> ff = findField(index);
        if (ff == null)
            throw new IllegalStateException("Field cannot find: " + index);
        setData(ff, value);
    }

    private  <T extends Comparable<T>> void setData(FieldFormat<T> ff, Object value) {
        try {
            ff.validate((T)value);
        } catch (ClassCastException e){
            throw new ClassCastException("invalid type conversion");
        }

        data.put(ff.getName(), value);
    }

    public <T extends Comparable<T>> Object getValue(int index) {
        FieldFormat<T> ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName) {
        return data.get(fieldName);
    }

    private  <T extends Comparable<T>> FieldFormat<T> findField(int index) {
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
