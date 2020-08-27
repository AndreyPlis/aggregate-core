package com.tibbo.datatable;

import java.util.Comparator;

public class CompareFields implements Comparator<DataRecord> {
    String fieldName;
    Boolean desc;

    public CompareFields(String fieldName, Boolean desc) {
        this.fieldName = fieldName;
        this.desc = desc;
    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {
        if (o1.getValue(fieldName) instanceof Integer)
            if (desc)
                return ((Integer) o1.getValue(fieldName)).compareTo((Integer) o2.getValue(fieldName));
            else
                return ((Integer) o2.getValue(fieldName)).compareTo((Integer) o1.getValue(fieldName));
        else if (o1.getValue(fieldName) instanceof String)
            if (desc)
                return ((String) o1.getValue(fieldName)).compareTo((String) o2.getValue(fieldName));
            else
                return ((String) o2.getValue(fieldName)).compareTo((String) o1.getValue(fieldName));
        else
            if (desc)
                return ((Boolean) o1.getValue(fieldName)).compareTo((Boolean) o2.getValue(fieldName));
            else
                return ((Boolean) o2.getValue(fieldName)).compareTo((Boolean) o1.getValue(fieldName));
    }
}
