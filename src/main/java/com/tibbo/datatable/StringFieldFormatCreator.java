package com.tibbo.datatable;

public class StringFieldFormatCreator extends FieldFormatCreator{
    @Override
    public FieldFormat create(String... attr){
        StringFieldFormat stringFieldFormat = new StringFieldFormat();

        return FieldFormatCreator.setFields(stringFieldFormat, attr);
    }
}
