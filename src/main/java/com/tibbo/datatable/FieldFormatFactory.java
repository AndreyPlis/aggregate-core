package com.tibbo.datatable;

public class FieldFormatFactory {
    public static FieldFormat<?> createFieldFormat(Character type, String name, String description, Boolean nullable, Boolean hidden) {
        FieldFormat<?> fieldFormat = createFieldFormat(type, name, description, nullable);
        fieldFormat.setHidden(hidden);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name, String description, Boolean nullable) {
        FieldFormat<?> fieldFormat = createFieldFormat(type, name, description);
        fieldFormat.setNullable(nullable);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name, String description) {
        FieldFormat<?> fieldFormat = createFieldFormat(type, name);
        fieldFormat.setDescription(description);
        return fieldFormat;
    }

    public static FieldFormat<?> createFieldFormat(Character type, String name) {
        FieldFormat<?> fieldFormat;
        switch (type) {
            case FieldFormat.STRING_FIELD -> fieldFormat = new StringFieldFormat();
            case FieldFormat.BOOLEAN_FIELD -> fieldFormat = new BooleanFieldFormat();
            case FieldFormat.INTEGER_FIELD -> fieldFormat = new IntFieldFormat();
            default -> throw new IllegalArgumentException("Wrong FieldFormat type" + type);
        }
        fieldFormat.setName(name);
        return fieldFormat;
    }

}
