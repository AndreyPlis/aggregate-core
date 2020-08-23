package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {

    private int minRowCount = 0;
    private int maxRowCount = 0;
    private List<FieldFormat> fields = new ArrayList<>();

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }

    public int getMinRowCount() {
        return minRowCount;
    }

    public void setMinRowCount(int minRowCount) {
        this.minRowCount = minRowCount;
    }

    public int getMaxRowCount() {
        return maxRowCount;
    }

    public void setMaxRowCount(int maxRowCount) {
        this.maxRowCount = maxRowCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        return minRowCount == that.minRowCount &&
                maxRowCount == that.maxRowCount &&
                fields.equals(that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minRowCount, maxRowCount, fields);
    }

    @Override
    public String toString() {
        return "TableFormat{" +
                "min=" + minRowCount +
                ", max=" + maxRowCount +
                ", fields=" + fields +
                '}';
    }

    @Override
    protected TableFormat clone() throws CloneNotSupportedException {
        TableFormat tableFormat = (TableFormat) super.clone( );
        return tableFormat;
    }
}
