package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();
    private Map<String, Integer> fieldsLookup = null;

    private Integer minRecords;
    private Integer maxRecords;

    public TableFormat() {
    }

    public TableFormat(Integer minRecords, Integer maxRecords) {
        this.minRecords = minRecords;
        this.maxRecords = maxRecords;
    }

    public TableFormat addField(FieldFormat fieldFormat) {
        for (FieldFormat ff : fields)
            if (ff.equals(fieldFormat))
                throw new IllegalStateException("Find duplicate field: " + fieldFormat);
        fields.add(fieldFormat);
        eraseFieldsLookup();
        return this;
    }

    public FieldFormat getField(int index) {
        if (index < 0 || index >= fields.size())
            throw new IndexOutOfBoundsException("Index invalid");
        return fields.get(index);
    }

    public FieldFormat getField(String name) {
        if (fieldsLookup == null) {
            fieldsLookup = new HashMap<>();
            for (int i = 0; i < getFieldCount(); i++) {
                fieldsLookup.put(fields.get(i).getName(), i);
            }
        }
        return getField(fieldsLookup.get(name));
    }

    private void eraseFieldsLookup() {
        if (fieldsLookup != null)
            fieldsLookup.clear();
        fieldsLookup = null;
    }


    public void removeField(FieldFormat fieldFormat) {
        if (fields.remove(fieldFormat))
            eraseFieldsLookup();
        else
            throw new IllegalStateException("Cannot find field " + fieldFormat);
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
        return Objects.equals(fields, that.fields) &&
                Objects.equals(fieldsLookup, that.fieldsLookup) &&
                Objects.equals(minRecords, that.minRecords) &&
                Objects.equals(maxRecords, that.maxRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, fieldsLookup, minRecords, maxRecords);
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
