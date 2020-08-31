package com.tibbo.datatable;

import java.util.Comparator;

public class ComparisonFields implements  Comparator<DataRecord> {
    String fieldName;
    Boolean desc;

    public ComparisonFields(String fieldName, Boolean desc) {
        this.fieldName = fieldName;
        this.desc = desc;
    }
    @Override
    public int compare(DataRecord o1, DataRecord o2) {
        Comparable value1 = (Comparable) o1.getValue(fieldName);
        Comparable value2 = (Comparable) o2.getValue(fieldName);

        if (desc)
            return (value1.compareTo(value2));
        else
            return (value2.compareTo(value1));
    }

}
