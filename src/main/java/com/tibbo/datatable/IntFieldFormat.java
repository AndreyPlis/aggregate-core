package com.tibbo.datatable;

public class IntFieldFormat extends FieldFormat<Integer> {

    @Override
    public String valueToString(Integer value) {
        return value.toString();
    }

    @Override
    public char getType() {
        return FieldFormat.INTEGER_FIELD;
    }
}
