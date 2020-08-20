package com.tibbo.datatable;

import java.util.*;

public class DataRecord implements Cloneable{
    TableFormat tableFormat;
    List<Object> values = new ArrayList<>();

    public DataRecord(TableFormat tableFormat){
        this.tableFormat = tableFormat;
        if(tableFormat != null){
            for(int i=0; i < tableFormat.getFieldsSize(); i++){
                values.add(tableFormat.getFieldDefaultValue(i));
            }
        }
    }

    public <T> void setValue(String fieldName, T value){
        int index = 0;
        while(index < tableFormat.getFieldsSize() && !fieldName.equals(tableFormat.getFieldName(index))){
            index++;
        }
        if( index < tableFormat.getFieldsSize() && fieldName.equals(tableFormat.getFieldName(index)) ){
            if( !values.get(index).getClass().equals(value.getClass()) ){
                throw new IllegalStateException("data types do not match in setValue");
            }
            else {
                values.set(index, value);
            }
        }
        else{
            throw new IllegalStateException("field with name '"+ fieldName + "' wasn't found in setValue");
        }
    }

    public <T> void setValue(int fieldIndex, T value){
        if(values == null || fieldIndex < 0 || fieldIndex > values.size()){
            throw new IllegalStateException("wrong fieldIndex in setValue: " + fieldIndex);
        }
        else if( !values.get(fieldIndex).getClass().equals(value.getClass()) ){
            throw new IllegalStateException("data types do not match in setValue");
        }
        else {
            values.set(fieldIndex, value);
        }
    }
}
