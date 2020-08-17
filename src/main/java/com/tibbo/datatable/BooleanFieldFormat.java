package com.tibbo.datatable;

public class BooleanFieldFormat extends FieldFormat<Boolean> {

    @Override
    public String valueToString(Boolean value) {
        return value.toString();
    }

    @Override
    public Boolean valueFromString(String value) {
        return Boolean.valueOf(value);
    }

    @Override
    public char getType() {
        return FieldFormat.BOOLEAN_FIELD;
    }
}
