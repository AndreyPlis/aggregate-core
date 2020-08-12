package com.tibbo.datatable;

public class IntFieldFormat extends FieldFormat<Integer> {
    private Integer defaultValue = 1;
    @Override
    public String valueToString(Integer value) {
        return value.toString();
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }

    @Override
    public Integer valueFromString(String value) {
        return Integer.parseInt( value );
    }
}
