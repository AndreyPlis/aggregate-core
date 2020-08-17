package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();

    private Integer minRecords;
    private Integer maxRecords;

    public TableFormat() {
        this(1,1);
    }

    public TableFormat(Integer minRecords, Integer maxRecords) {
        this.minRecords = minRecords;
        this.maxRecords = maxRecords;
    }

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }


    @Override
    protected TableFormat clone() throws CloneNotSupportedException {
        TableFormat clone = (TableFormat) super.clone();
        ArrayList<FieldFormat> list = new ArrayList<>();
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
        return Objects.hash(fields);
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
}
