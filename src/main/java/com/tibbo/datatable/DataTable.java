package com.tibbo.datatable;

public interface DataTable {

    void addRecord(DataRecord dataRecord);

    void addRecord(DataRecord dataRecord,int index);

    void removeRecord(int index);

    DataRecord rec(); //return first row

    Object get(); //return value of first row and first field

    DataRecord getRecord(int index);

    void setCellValue(String field, int index, Object value);

    Object getCellValue(String field, int index);

    TableFormat getFormat();

    int getRecordsCount();

    void sort(String fieldName, boolean desc);

    DataTable filter(String fieldName, Object value);
}
