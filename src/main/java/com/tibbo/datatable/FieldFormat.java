package com.tibbo.datatable;

import java.util.*;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden = false;
    private T value;
    //private T defaultValue;

    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';
    public static final char BOOLEAN_FIELD = 'B';

    public abstract String valueToString(T value);

    public abstract T valueFromString(String value);

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldFormat<?> that = (FieldFormat<?>) o;
        return name.equals(that.name) &&
                description.equals(that.description) &&
                nullable.equals(that.nullable) &&
                hidden.equals( that.hidden );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, nullable, hidden);
    }

    @Override
    public String toString() {
        return "FieldFormat{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nullable=" + nullable +
                ", hidden=" + hidden +
                '}';
    }
}
