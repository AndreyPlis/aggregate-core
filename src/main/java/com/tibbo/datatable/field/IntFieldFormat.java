package com.tibbo.datatable.field;

import com.tibbo.datatable.field.*;

public class IntFieldFormat<T> extends FieldFormat<T> {

    @Override
    public String valueToString(T value) {
        return value.toString();
    }

    @Override
    public Object valueFromString(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }
}
