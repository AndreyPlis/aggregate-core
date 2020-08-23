package com.tibbo.datatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataRecord {
    private final TableFormat tableFormat;

    private List dataRecordList = new ArrayList<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void addValue(int index, Object value){
        tableFormat.getField(index).validate(value);
        dataRecordList.add(index, value);
    }

    public void setValue(int index, Object value) {
        tableFormat.getField(index).validate(value);
        dataRecordList.set(index, value);
    }

    public Object getValue(int index) {
        return dataRecordList.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        DataRecord that = (DataRecord) o;
        return Objects.equals(dataRecordList, that.dataRecordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataRecordList);
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "dataList=" + dataRecordList +
                '}';
    }
}