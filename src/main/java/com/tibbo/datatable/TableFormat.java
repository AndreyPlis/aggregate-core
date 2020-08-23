package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();

    private int minCountLine;
    private int maxCountLine;

    public int getMinCountLine() {
        return minCountLine;
    }

    public void setMinCountLine(int minCountLine) {
        this.minCountLine = minCountLine;
    }

    public int getMaxCountLine() {
        return maxCountLine;
    }

    public void setMaxCountLine(int maxCountLine) {
        this.maxCountLine = maxCountLine;
    }

    public FieldFormat getField(int value){
        return fields.get(value);
    }

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }

    public TableFormat(int min, int max){
        if(min > max){
            throw new IllegalArgumentException("MinCountLine cannot be greater than the MaxCountLine");
        }
        setMinCountLine(min);
        setMaxCountLine(max);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        return minCountLine == that.minCountLine &&
                maxCountLine == that.maxCountLine &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, minCountLine, maxCountLine);
    }

    @Override
    public String toString() {
        return "TableFormat{" +
                "fields=" + fields +
                ", minCountLine=" + minCountLine +
                ", maxCountLine=" + maxCountLine +
                '}';
    }

}
