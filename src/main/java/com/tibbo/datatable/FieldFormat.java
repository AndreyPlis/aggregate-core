package com.tibbo.datatable;

import java.util.*;

public abstract class FieldFormat<T> implements Cloneable {
    private String name;
    private String description;

    private Boolean nullable;
    private Boolean hidden;

    private T defaultValue;


    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';
    public static final char BOOLEAN_FIELD = 'B';


    public abstract String valueToString(T value);

    public abstract T valueFromString(String value);

    public abstract char getType();


    public String getName() {
        return name;
    }
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

    public Boolean getHidden() { return hidden; }
    public void setHidden(Boolean hidden) { this.hidden = hidden; }

    public T getDefaultValue() { return defaultValue; }
    public void setDefaultValue(T defaultValue) { this.defaultValue = defaultValue; }



    @Override
    protected Object clone() throws CloneNotSupportedException {
         return super.clone();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getNullable(), getHidden(), getDefaultValue());
    }

    @Override
    public String toString() {
        return "FieldFormat{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nullable=" + nullable +
                ", hidden=" + hidden +
                ", defaultValue=" + defaultValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldFormat)) return false;
        FieldFormat<?> that = (FieldFormat<?>) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getNullable(), that.getNullable()) &&
                Objects.equals(getHidden(), that.getHidden()) &&
                Objects.equals(getDefaultValue(), that.getDefaultValue());
    }
}
