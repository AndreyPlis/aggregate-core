package com.tibbo.datatable;

public class BooleanFieldFormat extends FieldFormat<Boolean> {

    @Override
    public String valueToString(Boolean value) {
        return Boolean.toString(value);
    }

    @Override
    public Boolean valueFromString(String value) {
        return Boolean.getBoolean(value);
    }

    @Override
    public char getType() {
        return FieldFormat.BOOLEAN_FIELD;
    }
}
