package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord<T> {

    private TableFormat tableFormat;

    private Map<String,Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void setValue(String fieldName, Object value)
    {

        data.put(fieldName, value);
    }

    public void setValue(int index, Object value)
    {
        FieldFormat ff = findField(index);
        ff.validate(value);
        setValue(ff.getName(),value);
    }

    public Object getValue(int index) throws ValidationException {
        if(index < 0 || index >= data.size()){
            throw new ValidationException("index is not validate");
        }
        FieldFormat<T> ff = findField(index);
        return getValue(ff.getName());
    }

    public TableFormat getTableFormat() {
        return tableFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord<T> that = (DataRecord) o;
        return Objects.equals(tableFormat, that.tableFormat) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableFormat, data);
    }

    @Override
    protected DataRecord<T> clone() throws CloneNotSupportedException {
        DataRecord<T>  dt = (DataRecord) super.clone();
        dt.tableFormat = tableFormat.clone();
        Iterator<Map.Entry<String, Object>> itr = data.entrySet().iterator();
        dt.data.putAll(data);
        return  dt;
    }

    public Object getValue(String fieldName)
    {
        boolean flag = false;
        for(int i  = 0; i < tableFormat.getFieldCount(); i++){
            if(tableFormat.getField(i).getName().equals(fieldName)) flag = true;
        }
        if (flag) return data.get(fieldName);
        else  throw new NullPointerException("cell is null");
    }

    private FieldFormat findField(int index)
    {
        return tableFormat.getField(index);
    }
}
