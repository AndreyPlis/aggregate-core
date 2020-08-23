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

    public <T> void setFieldValue(String fieldName, T value){
        int index = 0;
        while(index < tableFormat.getFieldsSize() && !fieldName.equals(tableFormat.getFieldName(index))){
            index++;
        }
        if( index < tableFormat.getFieldsSize() && fieldName.equals(tableFormat.getFieldName(index)) ){
            if( (value == null && tableFormat.isFieldNullable(index) )
                    || values.get(index).getClass().equals(value.getClass()) ){
                tableFormat.validateField(index, value);
                values.set(index, value);
            }
            else {

                throw new IllegalStateException("data types do not match in setFieldValue()");
            }
        }
        else{
            throw new IllegalStateException("field with name '"+ fieldName + "' wasn't found in setFieldValue()");
        }
    }

    public <T> void setFieldValue(int index, T value){
        if(values == null || index < 0 || index > values.size()){
            throw new IllegalStateException("wrong fieldIndex in setFieldValue(): " + index);
        }
        else if( (value == null && tableFormat.isFieldNullable(index) )
                || values.get(index).getClass().equals(value.getClass()) ){
            tableFormat.validateField(index, value);
            values.set(index, value);
        }
        else {
            throw new IllegalStateException("data types do not match in setFieldValue()");

        }
    }

    public Object getFieldValue(String fieldName){
        int index = 0;
        while(index < tableFormat.getFieldsSize() && !fieldName.equals(tableFormat.getFieldName(index))){
            index++;
        }
        if( index < tableFormat.getFieldsSize() && fieldName.equals(tableFormat.getFieldName(index)) ){
            return values.get(index);
        }
        else{
            throw new IllegalStateException("field with name '"+ fieldName + "' wasn't found in getFieldValue()");
        }
    }

    public Object getFieldValue(int fieldIndex){
        if(values == null || fieldIndex < 0 || fieldIndex > values.size()){
            throw new IllegalStateException("wrong fieldIndex in getFieldValue(): " + fieldIndex);
        }
        else  {
            return values.get(fieldIndex);
        }
    }
}
