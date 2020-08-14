package com.tibbo.datatable;

public class IntFieldFormat extends FieldFormat<Integer> {
    private final Integer defaultValue = 1;

    @Override
    public String valueToString(Integer value) {
        return value.toString();
    }

    @Override
    public Integer valueFromString(String value) {
        return Integer.parseInt( value );
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }
}
