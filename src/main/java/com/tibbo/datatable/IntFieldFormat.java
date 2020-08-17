package com.tibbo.datatable;

public class IntFieldFormat extends FieldFormat<Integer> {

    @Override
    public String valueToString(Integer value) {
        return value.toString();
    }

    @Override
    public Integer valueFromString(String value) {
        return Integer.parseInt(value); //added 1.2
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }
}
