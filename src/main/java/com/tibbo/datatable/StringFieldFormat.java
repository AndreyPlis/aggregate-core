package com.tibbo.datatable;

public class StringFieldFormat extends FieldFormat<String> {


    @Override
    public String valueToString(String value) {
        return value;
    }

    @Override
    public String valueFromString(String value) {
        return value; //added 1.2
    }

    @Override
    public char getType() {
        return FieldFormat.STRING_FIELD;
    }
}
