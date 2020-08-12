package com.tibbo.datatable;

public class BooleanFieldFormat extends FieldFormat<Boolean> {
    private Boolean defaultValue = true;
    @Override
    public String valueToString(Boolean value) {
        return value.toString( );
    }

    @Override
    public Boolean valueFromString(String value) {
        return Boolean.parseBoolean( value );
    }

    @Override
    public char getType() {
        return BOOLEAN_FIELD;
    }
}
