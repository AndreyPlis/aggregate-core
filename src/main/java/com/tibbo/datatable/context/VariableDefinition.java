package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.Objects;

public class VariableDefinition implements Cloneable {

    private String name;
    private boolean writable;

    private TableFormat format;

    public VariableDefinition(String name, boolean writable, TableFormat format) {
        this.name = name;
        this.writable = writable;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public TableFormat getFormat() {
        return format;
    }

    public void setFormat(TableFormat format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableDefinition that = (VariableDefinition) o;
        return writable == that.writable &&
                Objects.equals(name, that.name) &&
                Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, writable, format);
    }

    @Override
    public String toString() {
        return "VariableDefinition{" +
                "name='" + name + '\'' +
                ", writable=" + writable +
                ", format=" + format +
                '}';
    }

    @Override
    public VariableDefinition clone() throws CloneNotSupportedException {
        return (VariableDefinition) super.clone();
    }
}
