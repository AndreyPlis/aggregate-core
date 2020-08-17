package com.tibbo.datatable;

public class BooleanFieldFormat extends FieldFormat<Boolean> {
    char typeField = BOOLEAN_FIELD;

    @Override
    public String valueToString(Boolean value) {
        return value.toString();
    }

    @Override
    public Boolean valueFromString(String value) {
        return Boolean.parseBoolean(value);
    }

    @Override
    public char getType() {
        return typeField;
    }

    @Override
    public FieldFormat clone() {
        BooleanFieldFormat tmp = new BooleanFieldFormat();
        tmp.setName(this.getName());
        tmp.setDescription(this.getDescription());
        tmp.setNullable(this.getNullable());
        tmp.setHidden(this.getHidden());
        tmp.setDefaultValue(this.getDefaultValue());
        return tmp;
    }
}
