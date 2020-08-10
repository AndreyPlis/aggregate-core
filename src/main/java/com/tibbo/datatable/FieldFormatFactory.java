package com.tibbo.datatable;

public class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = null;
        if (type == FieldFormat.STRING_FIELD)
            ff = new StringFieldFormat();
        else if (type == FieldFormat.INTEGER_FIELD)
            ff = new IntFieldFormat();
        ff.setName(name);
        ff.setDescription(description);
        return ff;
    }
}
