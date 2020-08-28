package com.tibbo.datatable;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleDataTable implements DataTable, Cloneable {
    private List<DataRecord> dataRecords = new ArrayList<>();
    private TableFormat tableFormat;

    public SimpleDataTable(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    @Override
    public void addRecord(DataRecord dataRecord) {
        dataRecords.add(dataRecord);
    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) {
        dataRecords.add(index, dataRecord);
    }

    @Override
    public void removeRecord(int index) {
        dataRecords.remove(index);
    }

    @Override
    public DataRecord rec() {
        return dataRecords.get(0);
    }

    @Override
    public Object get() {
        return dataRecords.get(0).getValue(0);
    }

    @Override
    public DataRecord getRecord(int index) {
        return dataRecords.get(index);
    }

    @Override
    public void setCellValue(String field, int index, Object value) {
        if(field == null || value == null){
            throw new NullPointerException("Fields or value  = null");
        }
        if(index < 0){
            throw new IllegalArgumentException("Index less than 0");
        }
        dataRecords.get(index).setValue(field, value);
    }

    @Override
    public Object getCellValue(String field, int index) {
        if(field == null){
            throw new NullPointerException("Field = 0");
        }
        if(index < 0){
            throw new IllegalArgumentException("Index less than 0");
        }
        if(index < dataRecords.size()){
            throw new IllegalArgumentException("Index greater than array length");
        }
        return dataRecords.get(index).getValue(field);
    }

    @Override
    public TableFormat getFormat() {
        return tableFormat;
    }

    @Override
    public int getRecordsCount() {
        return dataRecords.size();
    }

    @Override
    public void sort(String fieldName, boolean desc) {
       //Доделать
    }

    @Override
    public DataTable filter(String fieldName, Object value) {
        DataTable dataTable = new SimpleDataTable(tableFormat);
        List<DataRecord> dataRecords1 = dataRecords.stream().filter(dataRecord -> value.equals(dataRecord.getValue(fieldName))).collect(Collectors.toList());
        for (DataRecord record : dataRecords1)
            dataTable.addRecord(record);
        return dataTable;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SimpleDataTable clone = (SimpleDataTable) super.clone();
        List<DataRecord> list = new ArrayList<>();
        for (DataRecord dataRecord : dataRecords) list.add(dataRecord.clone());
        return clone;
    }
}
