package com.tibbo.datatable.field;

import com.tibbo.datatable.field.*;

public class IntFieldFormat extends FieldFormat<Integer> {

    @Override
    public String valueToString(Integer value) {
        return value.toString();
    }

    @Override

    public Integer valueFromString(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }
}
