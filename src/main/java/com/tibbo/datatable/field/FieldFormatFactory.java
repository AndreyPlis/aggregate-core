package com.tibbo.datatable.field;

import java.util.*;

public class FieldFormatFactory {
    /** Taken from https://stackoverflow.com/questions/34291714/how-to-implement-factory-pattern-with-generics-in-java
     *  Author: OldCurmudgeon
     */
     enum ValidCreators{
        String {
            @Override
            FieldFormat<String> handler() {
                return new StringFieldFormat();
            }
        },
        Integer {
            @Override
            FieldFormat<Integer> handler() {
                return new IntFieldFormat();
            }
        },
        Boolean {
            @Override
            FieldFormat<Boolean> handler(){
                return new BooleanFieldFormat();
            }
        };
        abstract <T> FieldFormat<T> handler();
    }

    public static <T> FieldFormat<T> createFieldFormat(Character type, String name, String description, Boolean hidden, T defaultValue) {
        FieldFormat<T> ff = createFieldFormat(type, name,description, hidden);
        ff.setDefaultValue(defaultValue);
        return ff;
    }

    public static<T> FieldFormat<T> createFieldFormat(Character type, String name, String description, Boolean hidden) {
        FieldFormat<T> ff = createFieldFormat(type, name,description);
        ff.setHidden(hidden);
        return ff;
    }

    public static <T> FieldFormat<T> createFieldFormat(Character type, String name, String description) {
        FieldFormat<T> ff = createFieldFormat(type, name);
        ff.setDescription(description);
        return ff;
    }

    public static <T> FieldFormat<T> createFieldFormat(Character type, String name){
        FieldFormat<T> ff;
        if (type == FieldFormat.STRING_FIELD)
            ff = ValidCreators.String.handler();//new StringFieldFormat();
        else if (type == FieldFormat.INTEGER_FIELD)
            ff = ValidCreators.Integer.handler(); //new IntFieldFormat();
        else if (type == FieldFormat.BOOLEAN_FIELD)
            ff = ValidCreators.Boolean.handler(); //new BooleanFieldFormat();
        else
            throw new IllegalStateException("unknown type: " + type);
        ff.setName(name);
        return ff;
    }
}
