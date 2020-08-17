package com.tibbo.datatable;

public class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String name, String description, Boolean hidden) {
        FieldFormat ff = null;
        if (type == FieldFormat.STRING_FIELD) {
            ff = new StringFieldFormat();
            ff.setDefaultValue("Need text");
        } else if (type == FieldFormat.INTEGER_FIELD){
            ff = new IntFieldFormat();
            ff.setDefaultValue("0");
        }
        else if (type == FieldFormat.BOOLEAN_FIELD){
            ff = new BooleanFieldFormat();
            ff.setDefaultValue("true");
        }
        ff.setName(name);
        ff.setDescription(description);
        ff.setHidden(hidden);
        return ff;
    }
}
