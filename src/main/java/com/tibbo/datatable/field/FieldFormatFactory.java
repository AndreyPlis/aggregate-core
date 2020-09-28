package com.tibbo.datatable.field;

public class FieldFormatFactory {


    public static <T> FieldFormat<T> createFieldFormat(Character type, String name, String description, Boolean hidden, T defaultValue) {
        FieldFormat<T> ff = createFieldFormat(type, name, description, hidden);
        ff.setDefaultValue(defaultValue);
        return ff;
    }

    public static <T>FieldFormat<T> createFieldFormat(Character type, String name, String description, Boolean hidden) {
        FieldFormat<T> ff = createFieldFormat(type, name,description);
        ff.setHidden(hidden);
        return ff;
    }

    public static <T>FieldFormat<T> createFieldFormat(Character type, String name, String description) {
        FieldFormat<T> ff = createFieldFormat(type, name);
        ff.setDescription(description);
        return ff;
    }

    public static <T>FieldFormat<T> createFieldFormat(Character type, String name){
        FieldFormat<T> ff;
        if (type == FieldFormat.STRING_FIELD)
            ff = new StringFieldFormat<T>();
        else if (type == FieldFormat.INTEGER_FIELD)
            ff = new IntFieldFormat<T>();
        else if (type == FieldFormat.BOOLEAN_FIELD)
            ff = new BooleanFieldFormat<T>();
        else
            throw new IllegalStateException("unknown type: " + type);
        ff.setName(name);
        return ff;
    }
}
