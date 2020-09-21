package com.tibbo.datatable;

public interface DataTable {

    void addRecord(DataRecord dataRecord);

    void addRecord(DataRecord dataRecord,int index) throws ValidationException;

    void removeRecord(int index) throws ValidationException;

    DataRecord rec(); //return first row

    Object get(); //return value of first row and first field

    DataRecord getRecord(int index) throws ValidationException;

    void setCellValue(String field, int index, Object value) throws ValidationException;

    Object getCellValue(String field, int index) throws ValidationException;

    TableFormat getFormat();

    int getRecordsCount();

    void sort(String fieldName, boolean desc);

    DataTable filter(String fieldName, Object value);
}
