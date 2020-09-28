package com.tibbo.datatable.field;

public class BooleanFieldFormat<T> extends FieldFormat<T> {
    @Override
    public String valueToString(T value) {
        return value.toString();
    }

    @Override
    public Object valueFromString(String value) {
        return Boolean.valueOf(value);
    }

    @Override
    public char getType() {
        return FieldFormat.BOOLEAN_FIELD;
    }
}
