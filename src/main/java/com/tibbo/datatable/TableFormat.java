package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class TableFormat<T> implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();

    private Integer minRecords;
    private Integer maxRecords;

    public TableFormat() {
    }

    public TableFormat(Integer minRecords, Integer maxRecords) {
        this.minRecords = minRecords;
        this.maxRecords = maxRecords;
    }

    public TableFormat<T> addField(FieldFormat fieldFormat) {
        fields.add(fieldFormat);
        return this;
    }

    public FieldFormat<T> getField(int index) {
        return fields.get(index);
    }



    public boolean removeField(FieldFormat fieldFormat) {
        return fields.remove(fieldFormat);
    }


    @Override
    protected TableFormat<T> clone() throws CloneNotSupportedException {
        TableFormat<T> clone = (TableFormat) super.clone();
        ArrayList<FieldFormat<T>> list = new ArrayList<>();
        for (FieldFormat field : fields) list.add(field.clone());
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        return Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, maxRecords, minRecords);
    }

    public Integer getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(Integer maxRecords) {
        this.maxRecords = maxRecords;
    }

    public Integer getMinRecords() {
        return minRecords;
    }

    public void setMinRecords(Integer minRecords) {
        this.minRecords = minRecords;
    }

    public int getFieldCount() {
        return fields.size();
    }
}
