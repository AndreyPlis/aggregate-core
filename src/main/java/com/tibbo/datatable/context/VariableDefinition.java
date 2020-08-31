package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

public class VariableDefinition {

    private String name;
    private boolean writable;

    private TableFormat format;

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
    public VariableDefinition clone() throws CloneNotSupportedException {
        VariableDefinition variableDefinition= (VariableDefinition) super.clone();
        variableDefinition.format = format;
        variableDefinition.name =name;
        variableDefinition.writable = writable;
        return  variableDefinition;
    }
}
