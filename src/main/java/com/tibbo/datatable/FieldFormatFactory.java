package com.tibbo.datatable;

public class FieldFormatFactory {

    @SafeVarargs
    public static <T> FieldFormat<?> createFieldFormat(Character type, T... args) {
        FieldFormat<?> fieldFormat = funcToCreateFieldFormat(type);
        setArguments(fieldFormat, args);
        return fieldFormat;
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

    @SafeVarargs
    private static <T> void setArguments(FieldFormat<?> fieldFormat, T... args) {
        switch (args.length) {
            case 5:
                fieldFormat.setDefaultValue((String) args[4]);
            case 4:
                fieldFormat.setHidden((Boolean) (args[3]));
            case 3:
                fieldFormat.setNullable((Boolean) (args[2]));
            case 2:
                fieldFormat.setDescription((String) args[1]);
            case 1:
                fieldFormat.setName((String) args[0]);
        }
    }
}
