package com.tibbo.datatable;

public class BooleanFieldFormatCreator extends FieldFormatCreator{
    @Override
    public FieldFormat create(String... attr){
        BooleanFieldFormat booleanFieldFormat = new BooleanFieldFormat();

        return FieldFormatCreator.setFields(booleanFieldFormat, attr);
    }
}
