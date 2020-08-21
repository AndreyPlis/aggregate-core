package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private int minRecords;
    private int maxRecords;
    private List<FieldFormat> fields = new ArrayList<>();

    public static final String FORMAT_OPEN = "<";
    public static final String FORMAT_CLOSE = ">";



    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }

    public int getMinRecords() {
        return minRecords;
    }

    public void setMinRecords(int minRecords) {
        this.minRecords = minRecords;
    }

    public int getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(int maxRecords) {
        this.maxRecords = maxRecords;
    }

    public List<FieldFormat> getFields() {
        return fields;
    }

    public void setFields(List<FieldFormat> fields) {
        this.fields = fields;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableFormat)) return false;
        TableFormat that = (TableFormat) o;
        return getMinRecords() == that.getMinRecords() &&
                getMaxRecords() == that.getMaxRecords() &&
                getFields().equals(that.getFields());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinRecords(), getMaxRecords(), getFields());
    }


    @Override
    public String toString() {
        return "TableFormat{" +
                "minRecords=" + minRecords +
                ", maxRecords=" + maxRecords +
                ", fields=" + fields +
                '}';
    }
}
