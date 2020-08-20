package com.tibbo.datatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataRecord {

    private List dataList = new ArrayList<>();


    public void addDataToList(TableFormat tableFormat, int index, String value) {
        tableFormat.getFields(index).validate(value);
        dataList.add(tableFormat.getFields(index).valueFromString(value));
    }

    public void changeDataList(TableFormat tableFormat, int index, String value) {
        tableFormat.getFields(index).validate(value);
        dataList.set(index, tableFormat.getFields(index).valueFromString(value));
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
