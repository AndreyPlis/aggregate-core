package com.tibbo.datatable;

import java.util.Comparator;

public class CompareFields implements Comparator<DataRecord> {
    String fieldName;

    public CompareFields(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {
        if (o1.getValue(fieldName) instanceof Integer)
            return ((Integer) o1.getValue(fieldName)).compareTo((Integer) o2.getValue(fieldName));
        else if (o1.getValue(fieldName) instanceof String)
            return ((String) o1.getValue(fieldName)).compareTo((String) o2.getValue(fieldName));
        else
            return ((Boolean) o1.getValue(fieldName)).compareTo((Boolean) o2.getValue(fieldName));
    }
}
