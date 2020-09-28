package com.tibbo.datatable.field;

import com.tibbo.datatable.*;
import com.tibbo.datatable.validator.*;

import java.util.*;

public abstract class FieldFormat<T> implements Cloneable {

    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';
    public static final char BOOLEAN_FIELD = 'B';

    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden;
    private T defaultValue;
    private List<FieldValidator> validators = new ArrayList<>();

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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public void addValidator(FieldValidator fieldValidator) {
        validators.add(fieldValidator);
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void validate(T value) {
        for (FieldValidator validator : validators) {
            try {
                validator.validate(value);
            } catch (ValidationException e) {
                throw new IllegalStateException(e);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldFormat<?> that = (FieldFormat<?>) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(nullable, that.nullable) &&
                Objects.equals(validators, that.validators) &&
                Objects.equals(hidden, that.hidden) &&
                Objects.equals(defaultValue, that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, nullable, validators, hidden, defaultValue);
    }

    @Override
    public FieldFormat<T> clone() {
        try {
            FieldFormat<T> ff = (FieldFormat<T>) super.clone();
            return ff;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("cannot clone", e);
        }
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
}
