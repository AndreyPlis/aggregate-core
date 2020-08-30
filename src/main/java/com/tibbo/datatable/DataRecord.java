package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord implements Cloneable {

    private TableFormat tableFormat;

    private Map<String,Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void setValue(String fieldName, Object value)
    {
        FieldFormat ff = findField(fieldName);
        if(ff == null){
            throw new IllegalStateException("Field with name " + fieldName + " was not found.");
        }
        else
        {
            ff.validate(value);
            data.put(fieldName, value);
        }
    }

    public void setValue(int index, Object value)
    {
        if(index < 0 || index > tableFormat.getFieldCount() ){
            throw new IllegalStateException("The index is out range in setValue() function.");
        }
        FieldFormat ff = findField(index);
        ff.validate(value);
        setValue(ff.getName(),value);
    }

    public Object getValue(int index)
    {
        if(index < 0 || index > tableFormat.getFieldCount() ){
            throw new IllegalStateException("The index is out range in getValue() function.");
        }
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName)
    {
        if( !data.containsKey(fieldName) ){
            throw new IllegalStateException("Field with name " + fieldName + " does not exist.");
        }
        return data.get(fieldName);
    }

    private FieldFormat findField(int index)
    {
        return tableFormat.getField(index);
    }

    private FieldFormat findField(String fieldName){
        for(int i=0; i<tableFormat.getFieldCount(); i++){
            if(fieldName.equals(tableFormat.getField(i).getName())){
                return tableFormat.getField(i);
            }
        }
        return null;
    }

    @Override
    protected DataRecord clone() throws CloneNotSupportedException {
        DataRecord clone = (DataRecord) super.clone();
        Map<String, Object> map = new LinkedHashMap<>();
        for(Map.Entry<String, Object> entry : data.entrySet()){
            map.put(entry.getKey(), entry.getValue());
        }
        clone.data = map;
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord that = (DataRecord) o;
        return Objects.equals(tableFormat, that.tableFormat) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableFormat, data);
    }
}
