package com.tibbo.datatable;

public class FieldFormatBuilder {

    private FieldFormat newFieldFormat = null;



    public FieldFormatBuilder() {
    }

    public FieldFormatBuilder withType(Character type)
    {
        if ( type == FieldFormat.STRING_FIELD)
            newFieldFormat = new StringFieldFormat();
        else if ( type == FieldFormat.INTEGER_FIELD)
            newFieldFormat = new IntFieldFormat();
        else if ( type == FieldFormat.BOOLEAN_FIELD)
            newFieldFormat = new BooleanFieldFormat();
        return this;
    }


    public FieldFormatBuilder withName(String name){
        newFieldFormat.setName(name);
        return this;
    }

    public FieldFormatBuilder withDescription(String description){
        newFieldFormat.setDescription(description);
        return this;
    }

    public FieldFormatBuilder withNullable(Boolean nullable){
        newFieldFormat.setNullable(nullable);
        return this;
    }

    public FieldFormatBuilder withHidden(Boolean hidden){
        newFieldFormat.setHidden(hidden);
        return this;
    }

    public <T> FieldFormatBuilder withDefaultValue(T defaultValue){
        newFieldFormat.setDefaultValue(defaultValue);
        return this;
    }

    public FieldFormat build() {
        return newFieldFormat;
    }

}