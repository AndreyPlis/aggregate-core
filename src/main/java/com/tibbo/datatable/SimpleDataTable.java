package com.tibbo.datatable;

import java.text.MessageFormat;
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
        compareTableFormat(dataRecord);
        dataRecords.add(dataRecord);
    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) {
        compareTableFormat(dataRecord);
        checkIndexValue(index);
        dataRecords.add(index, dataRecord);
    }

    @Override
    public void removeRecord(int index) {
        checkIndexValue(index);
        dataRecords.remove(index);
    }

    @Override
    public DataRecord rec() {
        checkForEmptyList();
        return dataRecords.get(0);
    }

    @Override
    public Object get() {
        checkForEmptyList();
        return dataRecords.get(0).getValue(0);
    }

    @Override
    public DataRecord getRecord(int index) {
        checkIndexValue(index);
        return dataRecords.get(index);
    }

    @Override
    public void setCellValue(String field, int index, Object value) {
        checkIndexValue(index);
        dataRecords.get(index).setValue(field, value);
    }

    @Override
    public Object getCellValue(String field, int index) {
        checkIndexValue(index);
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
        dataRecords.sort(new ComparisonFields(fieldName, desc));
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
    protected Object clone() throws CloneNotSupportedException {
        SimpleDataTable clone = (SimpleDataTable) super.clone();
        List<DataRecord> list = new ArrayList<>();
        for (DataRecord dataRecord : dataRecords) list.add(dataRecord.clone());
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

    @Override
    public String toString() {
        return dataRecords + " tableFormat=" + tableFormat;
    }

    private void compareTableFormat(DataRecord dataRecord){
        if (!tableFormat.equals(dataRecord.getTableFormat()))
            throw new IllegalStateException("Incorrect TableFormat");
    }
    private void checkIndexValue(int index) {
        if (index >= dataRecords.size() || index < 0)
            throw new IllegalStateException(MessageFormat.format("Index {0} out of bounds, must between 0 and {1}", index, dataRecords.size()));
    }

    private void checkForEmptyList(){
        if (dataRecords.isEmpty())
            throw new IllegalStateException("List of DataRecords is empty");

    }

}


