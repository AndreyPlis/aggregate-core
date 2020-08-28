package com.tibbo.datatable.field;

public class FieldFormatFactory {


    public static <T> FieldFormat<T> createFieldFormat(Character type, String name, String description, Boolean hidden, Boolean nullable, T defaultValue) {
        FieldFormat ff = createFieldFormat(type, name,description, hidden, nullable);
        ff.setDefaultValue(defaultValue);
        return ff;
    }
    public static FieldFormat createFieldFormat(Character type, String name, String description, Boolean hidden, Boolean nullable) {
        FieldFormat ff = createFieldFormat(type, name,description, hidden);
        ff.setNullable(nullable);
        return ff;
    }
    public static FieldFormat createFieldFormat(Character type, String name, String description, Boolean hidden) {
        FieldFormat ff = createFieldFormat(type, name,description);
        ff.setHidden(hidden);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = createFieldFormat(type, name);
        ff.setDescription(description);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name){
        FieldFormat ff = null;
        if (type == FieldFormat.STRING_FIELD)
            ff = new StringFieldFormat();
        else if (type == FieldFormat.INTEGER_FIELD)
            ff = new IntFieldFormat();
        else if (type == FieldFormat.BOOLEAN_FIELD)
            ff = new BooleanFieldFormat();
        else
            throw new IllegalStateException("unknown type: " + type);
        ff.setName(name);
        return ff;
    }
}
