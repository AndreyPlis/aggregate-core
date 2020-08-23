package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();
    private int minRecords = 0;
    private int maxRecords = Integer.MAX_VALUE;

    public TableFormat() {
        this(1, 1);
    }

    public TableFormat(int minRecords, int maxRecords) {
        this.minRecords = minRecords;
        this.maxRecords = maxRecords;
    }

    public int getMinRecords() {
        return minRecords;
    }

    public void setMinRecords(int minRecords) {
        this.minRecords = minRecords;
    }

    public int getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(int maxRecords) {
        this.maxRecords = maxRecords;
    }

    public boolean addField(FieldFormat fieldFormat)
    {
        if(fields != null) {
            return fields.add(fieldFormat);
        }
        return false;
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        if( fields != null) {
            return fields.remove(fieldFormat);
        }
        return false;
    }

    public int getFieldsSize(){
        return fields.size();
    }

    public char getFieldType(int index){
        if(fields == null || index < 0 || index > fields.size()){
            throw new IllegalStateException("wrong index in getFieldType(): " + index);
        }
        else{
            return fields.get(index).getType();
        }
    }

    public String getFieldName(int index){
        if(fields == null || index < 0 || index > fields.size()){
            throw new IllegalStateException("wrong index in getFieldName(): " + index);
        }
        else{
            return fields.get(index).getName();
        }
    }

    public <T> T getFieldDefaultValue(int index){
        if(fields == null || index < 0 || index > fields.size()){
            throw new IllegalStateException("wrong index in getFieldName(): " + index);
        }
        else{
            return (T) fields.get(index).getDefaultValue();
        }
    }

    public boolean isFieldNullable(int index){
        if(fields == null || index < 0 || index > fields.size()){
            throw new IllegalStateException("wrong index in isFieldNullable(): " + index);
        }
        else{
            return fields.get(index).getNullable().booleanValue();
        }
    }

    public <T> void validateField(int index, T value){
        if(fields == null || index < 0 || index > fields.size()){
            throw new IllegalStateException("wrong index in validateField(): " + index);
        }
        else{
            try{
                fields.get(index).validate(value);
            }
            catch (ValidateException e){
                throw new IllegalStateException("validation fail in validateField()", e);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TableFormat tableFormat = (TableFormat)o;
        return fields.equals(tableFormat.fields);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (fields == null ? 0 : fields.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = "fields: " + (fields == null ? "null" : fields.toString()) + ".";
        return result;
    }

    @Override
    public TableFormat clone() throws CloneNotSupportedException{
        TableFormat tableFormat = (TableFormat) super.clone();
        tableFormat.fields = new ArrayList<>();
        for(FieldFormat format:fields){
            tableFormat.fields.add(format.clone());
        }
        return tableFormat;
    }
}
