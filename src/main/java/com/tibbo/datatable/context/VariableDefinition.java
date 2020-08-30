package com.tibbo.datatable.context;

import java.util.*;

import com.tibbo.datatable.*;
import com.tibbo.datatable.field.*;

public class VariableDefinition implements Cloneable {

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

    public VariableDefinition clone() throws CloneNotSupportedException{
        VariableDefinition definition = (VariableDefinition) super.clone();
        TableFormat tableFormat = new TableFormat(format.getMinRecords(), format.getMaxRecords());
        for(int i=0; i<format.getFieldCount(); i++){
            tableFormat.addField( format.getField(i).clone() );
        }
        definition.setFormat(tableFormat);
        return definition;
    }
}
