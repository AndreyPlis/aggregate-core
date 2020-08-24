package com.tibbo.datatable;

import java.util.*;

public class SimpleDataTable implements DataTable, Cloneable {
    private List<DataRecord> dataRecords = new ArrayList<>();
    private TableFormat tableFormat;

    @Override
    public void addRecord(DataRecord dataRecord) {

    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) {

    }

    @Override
    public void removeRecord(int index) {

    }

    @Override
    public DataRecord getRecord(int index) {
        return null;
    }

    @Override
    public TableFormat getFormat() {
        return null;
    }

    @Override
    public int getRecordsCount() {
        return dataRecords.size();
    }

    @Override
    public void sort(String fieldName, boolean desc) {

    }

    @Override
    public DataTable filter(String fieldName, Object value) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        throw  new UnsupportedOperationException();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw  new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw  new UnsupportedOperationException();
    }
}
