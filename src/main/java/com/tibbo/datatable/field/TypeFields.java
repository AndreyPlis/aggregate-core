package com.tibbo.datatable.field;

public enum TypeFields {
    STRING_FIELD_FORMAT() {
        @Override
        public FieldFormat<String> create() {
            return new StringFieldFormat();
        }
    },
    INTEGER_FIELD_FORMAT() {
        @Override
        public FieldFormat<Integer> create() {
            return new IntFieldFormat();
        }
    },
    BOOLEAN_FIELD_FORMAT() {
        @Override
        public FieldFormat<Boolean> create() {
            return new BooleanFieldFormat();
        }
    };

    public abstract <T> FieldFormat<T> create();
}

