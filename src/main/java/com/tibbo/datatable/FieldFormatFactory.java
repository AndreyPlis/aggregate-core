package com.tibbo.datatable;

public class FieldFormatFactory<T> {

    public static <T>FieldFormat createFieldFormat(Character type, String name, String description, Boolean nullable, Boolean hidden, T defaultValue) {
        FieldFormat ff = createFieldFormat(type, name, description, nullable, hidden);
        ff.setDefaultValue(defaultValue);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name, String description, Boolean nullable, Boolean hidden) {
        FieldFormat ff = createFieldFormat(type, name, description, nullable);
        ff.setHidden(hidden);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name, String description, Boolean nullable) {
        FieldFormat ff = createFieldFormat( type, name, description );
        ff.setNullable(nullable);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = createFieldFormat( type, name );
        ff.setDescription(description);
        return ff;
    }

    public static FieldFormat createFieldFormat(Character type, String name) {
        FieldFormat ff = null;
        switch (type) {
            case FieldFormat.STRING_FIELD:
            {
                ff = new StringFieldFormat();
                break;
            }
            case FieldFormat.INTEGER_FIELD:
            {
                ff = new IntFieldFormat();
                break;
            }
            case FieldFormat.BOOLEAN_FIELD:
            {
                ff = new BooleanFieldFormat();
                break;
            }
        }
        ff.setName(name);
        return ff;
    }
}
