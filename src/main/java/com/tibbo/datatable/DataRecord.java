package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord implements Cloneable {

    private TableFormat tableFormat;

    private Map<String, Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
        for (int i = 0; i < tableFormat.getFieldCount(); i++) {
            data.put(tableFormat.getField(i).getName(), tableFormat.getField(i).getDefaultValue());
        }
    }

    public void setValue(String fieldName, Object value) {
        int index = 0;
        while (index < tableFormat.getFieldCount() && !fieldName.equals(tableFormat.getField(index).getName()))
            index++;
        if (index == tableFormat.getFieldCount()) {
            checkFieldName(fieldName);
        }
        setValue(index, value);
    }

    public void setValue(int index, Object value) {
        checkIndexValue(index);
        FieldFormat ff = findField(index);
        ff.validate(value);
        data.put(ff.getName(), value);
    }

    public Object getValue(int index) {
        checkIndexValue(index);
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName) {
        checkFieldName(fieldName);
        return data.get(fieldName);
    }


    private FieldFormat findField(int index) {
        return tableFormat.getField(index);
    }

    private void checkFieldName(String fieldName) {
        if (!data.containsKey(fieldName))
            throw new IllegalStateException(String.format("FieldName %s not found", fieldName));
    }

    private void checkIndexValue(int index) {
        if (index >= tableFormat.getFieldCount() || index < 0)
            throw new IllegalStateException(String.format("Index %d out of bounds, must between 0 and %d", index, tableFormat.getFieldCount()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord that = (DataRecord) o;
        return tableFormat.equals(that.tableFormat) &&
                data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableFormat, data);
    }

    @Override
    public String toString() {
        return "DataRecord = " + data + "\n";
    }

    @Override
    public DataRecord clone() throws CloneNotSupportedException {
        DataRecord clone = (DataRecord) super.clone();
        Map<String, Object> dataCopy = new LinkedHashMap<>();
        Set<Map.Entry<String, Object>> entries = clone.data.entrySet();
        for (Map.Entry<String, Object> mapEntry : entries) {
            dataCopy.put(mapEntry.getKey(), mapEntry.getValue());
        }
        clone.data = dataCopy;
        return clone;
    }

}
