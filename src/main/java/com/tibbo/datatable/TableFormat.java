package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();


    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }
}
