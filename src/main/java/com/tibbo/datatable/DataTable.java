package com.tibbo.datatable;

public interface DataTable {

    void addRecord(DataRecord dataRecord);

    void addRecord(DataRecord dataRecord,int index);

    void removeRecord(int index);

    DataRecord getRecord(int index);

    TableFormat getFormat();

    int getRecordsCount();

    void sort(String fieldName, boolean desc);

    DataTable filter(String fieldName, Object value);
}
