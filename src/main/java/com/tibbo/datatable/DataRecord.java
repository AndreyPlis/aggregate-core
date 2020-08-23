package com.tibbo.datatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataRecord {
    private final TableFormat tableFormat;

    private final List<Object> dataList = new ArrayList<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    public void setValue(int index, Object value) {
        tableFormat.getField(index).validate(String.valueOf(value));
        dataList.set(index, value);
    }

    public void addValue(int index, Object value){
        tableFormat.getField(index).validate(String.valueOf(value));
        dataList.add(index, value);
    }

    public Object getValue(int index) {
        return dataList.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord that = (DataRecord) o;
        return Objects.equals(dataList, that.dataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataList);
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "dataList=" + dataList +
                '}';
    }
}
