package com.tibbo.datatable;

import java.lang.reflect.Array;
import java.util.*;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable = true;
    private Boolean hidden = false;
    private T defaultValue;
    private List<FieldValidator> fieldValidators = new ArrayList<FieldValidator>();

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

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void addFieldValidator( FieldValidator fieldValidator ) {
        fieldValidators.add( fieldValidator );
    }

    protected void validate( T value ) throws ExceptionValidator {
        for (FieldValidator fieldValidator: fieldValidators) {
            try {
                fieldValidator.validate(value);
            } catch ( ExceptionValidator e){
                System.err.println( "Catch exception" );
            }
        }
    }

    @Override
    protected FieldFormat clone() throws CloneNotSupportedException {
        FieldFormat fieldFormat = (FieldFormat) super.clone( );
        return fieldFormat;
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
                Objects.equals(defaultValue, that.defaultValue) &&
                Objects.equals(fieldValidators, that.fieldValidators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, nullable, hidden, defaultValue, fieldValidators);
    }

    @Override
    public String toString() {
        return "FieldFormat{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nullable=" + nullable +
                ", hidden=" + hidden +
                ", defaultValue=" + defaultValue +
                ", fieldValidators=" + fieldValidators +
                '}';
    }
}
