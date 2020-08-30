package com.tibbo.datatable;

import java.util.*;

public class SimpleDataTable implements DataTable, Cloneable {
    private List<DataRecord> dataRecords = new ArrayList<>();
    private TableFormat tableFormat;

    public SimpleDataTable(TableFormat tableFormat){
        this.tableFormat = tableFormat;
    }

    @Override
    public void addRecord(DataRecord dataRecord) {
        if(dataRecord == null) {
            throw new IllegalStateException("Data record must not be null in addRecord() function.");
        }
        if(dataRecords.size() >= tableFormat.getMaxRecords()){
            throw new IllegalStateException("Maximum allowed dataRecords size reach.");
        }
        else{
            dataRecords.add(dataRecord);
        }
    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) {
        if(dataRecord == null){
            throw new IllegalStateException("Data record must not be null in addRecord() function.");
        }
        if(dataRecords.size() >= tableFormat.getMaxRecords()){
            throw new IllegalStateException("Maximum allowed dataRecords size reach.");
        }
        if(index > tableFormat.getMaxRecords()){
            throw new IllegalStateException("The index is out range in addRecord() function.");
        }
        try{
            dataRecords.add(index, dataRecord);
        }
        /** Wrong index value, when index < 0 or index > dataRecords.size() will catch here*/
        catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("The index is out range in addRecord() function.");
        }
    }

    @Override
    public void removeRecord(int index) {
        if(dataRecords == null){
            throw new IllegalStateException("dataRecords must not be null for removeRecord() function.");
        }
        if(index < 0 || index > dataRecords.size()){
            throw new IllegalStateException("The index is out range in removeRecord() function.");
        }
        if(dataRecords.size() <= tableFormat.getMinRecords()){
            throw new IllegalStateException("Minimum allowed dataRecords size reach.");
        }
        try{
            dataRecords.remove(index);
        }
        /** Wrong index value, when index < 0 or index > dataRecords.size() will catch here*/
        catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("The index is out range in removeRecord() function.");
        }
    }

    @Override
    public DataRecord rec() {
        if(dataRecords == null || dataRecords.size() == 0)
            return null;
        DataRecord dataRecord = null;
        try {
            dataRecord = dataRecords.get(0).clone();
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Can't clone data record in rec() function.", e);
        }
        return dataRecord;
    }

    @Override
    public Object get() {
        Object o = null;
        try {
            o = this.clone();
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Can't clone data record in get() function.", e);
        }
        return o;
    }

    @Override
    public DataRecord getRecord(int index) {
        if(dataRecords == null || dataRecords.size() <= index)
            return null;
        DataRecord dataRecord = null;
        try {
            dataRecord = dataRecords.get(index).clone();
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Can't clone data record in getRecord() function.", e);
        }
        return dataRecord;
    }

    @Override
    public void setCellValue(String field, int index, Object value) {
        if(index < 0 || index > dataRecords.size()){
            throw new IllegalStateException("The index is out range in setCellValue() function.");
        }
        /** If the field does not exist, it will catch in setValue() function */
        dataRecords.get(index).setValue(field, value);
    }

    @Override
    public Object getCellValue(String field, int index) {
        if(index < 0 || index > dataRecords.size()){
            throw new IllegalStateException("The index is out range in getCellValue() function.");
        }
        /** If the field does not exist, it will catch in getValue() function */
        return dataRecords.get(index).getValue(field);
    }

    @Override
    public TableFormat getFormat() {
        TableFormat format = null;
        try {
            format = tableFormat.clone();
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Can't get table format.", e);
        }
        return format;
    }

    @Override
    public int getRecordsCount() {
        return dataRecords.size();
    }

    @Override
    public void sort(String fieldName, boolean desc) {
        RecordComparator recordComparator = new RecordComparator(fieldName, desc);
        dataRecords.sort(recordComparator);
    }

    @Override
    public DataTable filter(String fieldName, Object value){
        SimpleDataTable table = null;
        try{
            table = this.clone();
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Can't clone SimpleDataTable in clone() function", e);
        }
        /**If the fieldName does not exist, it will catch in getValue() function */
        table.dataRecords.forEach(dataRecord -> dataRecord.getValue(fieldName).equals(value));
        return table;
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
    protected SimpleDataTable clone() throws CloneNotSupportedException {
        SimpleDataTable table = (SimpleDataTable) super.clone();
        List<DataRecord> records = new ArrayList<>();
        for(DataRecord rec : dataRecords){
            records.add(rec);
        }
        table.dataRecords = records;
        return table;
    }

}
