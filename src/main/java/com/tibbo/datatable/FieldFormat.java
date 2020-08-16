package com.tibbo.datatable;


import java.util.Objects;

public abstract class FieldFormat<T> implements Cloneable {
    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden;
    protected String defaultValue;

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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldFormat<?> that = (FieldFormat<?>) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(nullable, that.nullable) &&
                Objects.equals(hidden, that.hidden) &&
                Objects.equals(defaultValue, that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, nullable, hidden, defaultValue);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                ":\nname='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nullable=" + nullable +
                ", hidden=" + hidden;
    }

    @Override
    public FieldFormat<?> clone() {
        try {
            return (FieldFormat<?>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Object cannot be cloned", e);
        }
    }

}
