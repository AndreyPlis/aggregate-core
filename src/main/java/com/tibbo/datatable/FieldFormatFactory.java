package com.tibbo.datatable;

public class FieldFormatFactory {

    public static FieldFormat<?> createFieldFormat(Character type, String name, String description, Boolean nullable, Boolean hidden, String defaultValue) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        fieldFormat.setName(name);
        fieldFormat.setDescription(description);
        fieldFormat.setNullable(nullable);
        fieldFormat.setHidden(hidden);
        fieldFormat.setDefaultValue(defaultValue);
        return fieldFormat;
    }
    public static FieldFormat<?> createFieldFormat(Character type, String name, String description, Boolean nullable, Boolean hidden) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        fieldFormat.setName(name);
        fieldFormat.setDescription(description);
        fieldFormat.setNullable(nullable);
        fieldFormat.setHidden(hidden);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name, String description, Boolean nullable) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        fieldFormat.setName(name);
        fieldFormat.setDescription(description);
        fieldFormat.setNullable(nullable);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name, String description) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        fieldFormat.setName(name);
        fieldFormat.setDescription(description);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        fieldFormat.setName(name);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type) {
        return funcToCreateFieldFormat(type);
    }

    private static FieldFormat<?> funcToCreateFieldFormat(Character type) {
        FieldFormat<?> fieldFormat;
        switch (type) {
            case FieldFormat.STRING_FIELD -> fieldFormat = new StringFieldFormat();
            case FieldFormat.BOOLEAN_FIELD -> fieldFormat = new BooleanFieldFormat();
            case FieldFormat.INTEGER_FIELD -> fieldFormat = new IntFieldFormat();
            default -> throw new IllegalArgumentException("Wrong FieldFormat type" + type);
        }
        return fieldFormat;
    }
}
