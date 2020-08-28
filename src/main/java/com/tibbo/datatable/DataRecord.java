package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord {

    private TableFormat tableFormat;

    private Map<String,Object> data = new LinkedHashMap<>();

    private void validateInputData(Object value, int index, String fieldName){
        FieldFormat fieldFormat = null;
        if(index > 0){
            fieldFormat = findField(index);
        }
        if(fieldName.isEmpty() == false){
            fieldFormat = findField(fieldName);
        }
        if(fieldFormat == null){
            throw new NullPointerException("FieldFormat is null");
        }
        fieldFormat.validate( value );
        data.put(fieldFormat.getName(), value);
    }

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void setValue(String fieldName, Object value)
    {
        validateInputData(value, 0, fieldName);
    }

    public void setValue(int index, Object value)
    {
        validateInputData(value, index, "");
    }

    public Object getValue(int index)
    {
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName)
    {
        return data.get(fieldName);
    }

    private FieldFormat findField(int index)
    {
        return tableFormat.getField(index);
    }

    private FieldFormat findField( String fieldName )
    {
        return tableFormat.getField(fieldName);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DataRecord that = (DataRecord) object;
        return java.util.Objects.equals(tableFormat, that.tableFormat) &&
                java.util.Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tableFormat, data);
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "tableFormat=" + tableFormat +
                ", data=" + data +
                '}';
    }

    @Override
    public DataRecord clone(){
        try{
            return (DataRecord) super.clone();
        }
        catch (CloneNotSupportedException error){
            throw new IllegalArgumentException("Cant be used", error);
        }
    }

}
