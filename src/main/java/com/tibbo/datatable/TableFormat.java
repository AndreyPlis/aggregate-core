package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private int minCountField;
    private int maxCountField;

    private List<FieldFormat<?>> fields = new ArrayList<>();

    public TableFormat(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("minCountField must be greater than maxCountField");
        }
        this.minCountField = min;
        this.maxCountField = max;
    }

    public int getMinCountField() {
        return minCountField;
    }

    public void setMinCountField(int minCountField) {
        this.minCountField = minCountField;
    }

    public int getMaxCountField() {
        return maxCountField;
    }

    public void setMaxCountField(int maxCountField) {
        this.maxCountField = maxCountField;
    }

    public void addField(FieldFormat<?> fieldFormat) {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat<?> fieldFormat) {
        return fields.remove(fieldFormat);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "\nminCountField=" + minCountField +
                ", maxCountField=" + maxCountField +
                ", fields=" + fields +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        return minCountField == that.minCountField &&
                maxCountField == that.maxCountField &&
                Objects.equals(fields, that.fields);
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + minCountField + maxCountField + ((fields == null) ? 0 : fields.hashCode());
        return result;
    }

    public TableFormat clone() {
        TableFormat copy;
        try {
            copy = (TableFormat) super.clone();
            copy.fields = new ArrayList<>(fields.size());
            for (FieldFormat<?> f : fields) {
                copy.fields.add(f.clone());
            }
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Невозможно", e);
        }
        return copy;
    }
}
