package com.tibbo.datatable;

public class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = new FieldFormatBuilder()
                                .withType(type)
                                .withName(name)
                                .withDescription(description)
                                .build();
        return ff;
    }
}
