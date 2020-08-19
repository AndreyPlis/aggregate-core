package com.tibbo.datatable;

import java.util.*;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden;
    private String defaultValue;

    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';
    public static final char BOOLEAN_FIELD = 'B';

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

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void addValidator(FieldValidator fieldValidator) {
        validators.add(fieldValidator);
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
        if(this == o){
             return true;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        if(o == null){
            return false;
        }
        FieldFormat<?> fieldEquals = (FieldFormat<?>) o;
        return Objects.equals(name, fieldEquals.name) && Objects.equals( description, fieldEquals.description) &&
                Objects.equals(nullable, fieldEquals.nullable) && Objects.equals(hidden, fieldEquals.hidden) &&
                Objects.equals(defaultValue, fieldEquals.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, nullable, hidden, defaultValue);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n Description: " + description + "\n Nullable: " + nullable + "\n Hidden: " + hidden + "\n DefaultValue: " + defaultValue; //need upload from 1.6
    }

    @Override
    public FieldFormat<?> clone(){
        try{
            return (FieldFormat<?>) super.clone();
        } catch (CloneNotSupportedException error){
            throw new IllegalArgumentException("Cant be used", error);
        }

    }
}
