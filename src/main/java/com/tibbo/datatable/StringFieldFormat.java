package com.tibbo.datatable;

public class StringFieldFormat extends FieldFormat<String> {
    char typeField = STRING_FIELD;


    @Override
    public String valueToString(String value) {
        return value;
    }

    @Override
    public String valueFromString(String value) {
        return value;
    }

    @Override
    public char getType() {

        return typeField;
    }

    @Override
    public FieldFormat clone() {
        StringFieldFormat tmp = new StringFieldFormat();
        tmp.setName(this.getName());
        tmp.setDescription(this.getDescription());
        tmp.setNullable(this.getNullable());
        tmp.setHidden(this.getHidden());
        tmp.setDefaultValue(this.getDefaultValue());
        return tmp;
    }
}
