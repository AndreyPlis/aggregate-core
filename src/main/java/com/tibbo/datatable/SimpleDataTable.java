package com.tibbo.datatable;

import java.util.*;
import java.util.stream.*;

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
        return getRecord(0);
    }

    @Override
    public Object get() {
        if (rec() != null)
            return rec().getValue(0);
        return null;
    }

    @Override
    public DataRecord getRecord(int index) {
        DataRecord dr = dataRecords.get(index);
        if (dr == null)
            throw new IllegalStateException("Cannot find dataRecord with index:" + index);
        return dr;
    }

    @Override
    public void setCellValue(String field, int index, Object value) {
        DataRecord dr = getRecord(index);
        dr.setValue(field, value);
    }

    @Override
    public Object getCellValue(String field, int index) {
        return getRecord(index).getValue(field);
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
        dataRecords.sort((recordLeft, recordRight) -> {
            Object left = recordLeft.getValue(fieldName);
            Object right = recordRight.getValue(fieldName);
            if (left instanceof Comparable && right instanceof Comparable) {
                int res = ((Comparable) left).compareTo(right);
                return desc ? -res : res;
            }
            return 0;
        });
    }

    @Override
    public DataTable filter(String fieldName, Object value) {
        SimpleDataTable result = new SimpleDataTable(tableFormat);
        List<DataRecord> filters = dataRecords.stream().filter(dr -> dr.getValue(fieldName).equals(value)).collect(Collectors.toList());
        filters.forEach(result::addRecord);
        return result;
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
    protected SimpleDataTable clone() {
        try {
            SimpleDataTable clone = (SimpleDataTable) super.clone();
            clone.tableFormat = tableFormat.clone();
            clone.dataRecords = new ArrayList<>();
            dataRecords.forEach(dr -> clone.dataRecords.add(dr.clone()));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String toString() {
        return "SimpleDataTable{" +
                "dataRecords=" + dataRecords +
                ", tableFormat=" + tableFormat +
                '}';
    }
}
