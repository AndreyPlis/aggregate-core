package com.tibbo.datatable;

import java.util.*;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable;

    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';

    public abstract String valueToString(T value);

    public abstract T valueFromString(String value);

    public String getName() {
        return name;
    }

    public abstract char getType();

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
