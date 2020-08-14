package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private int min = 0;
    private int max = 0;
    private List<FieldFormat> fields = new ArrayList<>();

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        return min == that.min &&
                max == that.max &&
                fields.equals(that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, fields);
    }

    @Override
    public String toString() {
        return "TableFormat{" +
                "min=" + min +
                ", max=" + max +
                ", fields=" + fields +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
