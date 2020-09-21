package com.tibbo.datatable;

import com.tibbo.datatable.field.FieldFormat;

import java.util.*;

public class SimpleDataTable<T> implements DataTable, Cloneable {
    private List<DataRecord> dataRecords = new ArrayList<>();
    private TableFormat tableFormat;

    public SimpleDataTable( TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    @Override
    public void addRecord(DataRecord dataRecord) {
        if(dataRecord == null){
            throw new NullPointerException("dataRecord is null");
        }
        else
        dataRecords.add(dataRecord);
    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) throws ValidationException {
        if(dataRecord == null){
            throw new NullPointerException("dataRecord is null");
        }
        else if(index < 0 || index > dataRecords.size()) {
            throw new ValidationException("index is not validate");
        }
        else
            dataRecords.add(index, dataRecord);
    }

    @Override
    public void removeRecord(int index) throws ValidationException {
          if(index < 0 || index >= dataRecords.size()) {
            throw new ValidationException("index is not validate");
        }
        else
            dataRecords.remove(index);

    }

    @Override
    public DataRecord<T> rec() {
        return null;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public DataRecord<T> getRecord(int index) throws ValidationException {
        if(index < 0 || index >= dataRecords.size()) {
            throw new ValidationException("index is not validate");
        }
        return  dataRecords.get(index);
    }

    @Override
    public void setCellValue(String field, int index, Object value) throws ValidationException {
        if(index < 0 || index >= dataRecords.size()) {
            throw new ValidationException("index is not validate");
        }
        boolean flag = false;
        for(int i  = 0; i < tableFormat.getFieldCount(); i++){
            if(tableFormat.getField(i).getName().equals(field)) flag = true;
        }
        if(flag){
            dataRecords.get(index).setValue(field, value);
        }
        else {
            throw new ValidationException("field is not exists");
        }
    }

    @Override
    public Object getCellValue(String field, int index) throws ValidationException {
        if(index < 0 || index >= dataRecords.size()) {
            throw new ValidationException("index is not validate");
        }
        if(dataRecords.get(index).getValue(field) != null){
            return dataRecords.get(index).getValue(field);
        }
        else {
            throw new NullPointerException("cell is null");
        }
    }

    @Override
    public TableFormat getFormat() {
        return  tableFormat;
    }

    @Override
    public int getRecordsCount() {
        return dataRecords.size();
    }

    @Override
    public void sort(String fieldName, boolean desc) {
        FieldFormat<T> fieldFormat = null;
        for(int i =0; i < tableFormat.getFieldCount(); i++) {
            if (tableFormat.getField(i).getName() == fieldName) {
                fieldFormat = tableFormat.getField(i);
            }
        }
        dataRecords.sort( new ComparatorForDataRecords<T>(fieldFormat, desc));
    }

    @Override
    public DataTable filter(String fieldName, Object value) {
        if(value == null)   throw new NullPointerException("value is null");
        SimpleDataTable<T> myDataTable = new SimpleDataTable<T>(tableFormat);
        for(DataRecord<T> it: dataRecords){
            if(it.getValue(fieldName) == value){
                myDataTable.addRecord(it);
            }
        }
        return  myDataTable;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        SimpleDataTable<T> clone = (SimpleDataTable) super.clone();
        clone.tableFormat = tableFormat.clone();
        ArrayList<DataRecord<T>> list = new ArrayList<>();
        for (DataRecord<T> it : dataRecords) list.add((DataRecord) it.clone());
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDataTable that = (SimpleDataTable) o;
        return Objects.equals(dataRecords, that.dataRecords) &&
                Objects.equals(tableFormat, that.tableFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataRecords, tableFormat);
    }
}
