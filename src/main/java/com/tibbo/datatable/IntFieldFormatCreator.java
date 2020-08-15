package com.tibbo.datatable;

public class IntFieldFormatCreator extends FieldFormatCreator{
    @Override
    public FieldFormat create(String... attr){
        IntFieldFormat intFieldFormat = new IntFieldFormat();

        return FieldFormatCreator.setFields(intFieldFormat,attr);
    }
}
