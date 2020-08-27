package com.tibbo.datatable;

import java.util.*;

import com.tibbo.datatable.validator.*;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden;
    private T defaultValue;

    private List<FieldValidator> validators = new ArrayList<>();

    public static final char INTEGER_FIELD = 'I';
    public static final char STRING_FIELD = 'S';
    public static final char BOOLEAN_FIELD = 'B';

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

    public Boolean getHidden(){
        return hidden;
    }

    public void setHidden(Boolean hidden){
        this.hidden = hidden;
    }

    public T getDefaultValue(){
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue){
        this.defaultValue = defaultValue;
    }

    public boolean addValidator(FieldValidator validator){
        if(validators != null){
            return validators.add(validator);
        }
        return false;
    }

    public boolean removeValidator(FieldValidator validator){
        if(validators != null){
            return validators.remove(validator);
        }
        return false;
    }

    public void validate(Object value) {
        if( !value.getClass().equals(defaultValue.getClass()) ){
            throw new IllegalStateException("Mismatched data types");
        }
        try {
            for (FieldValidator validator : validators) {
                validator.validate(value);
            }
        }
        catch (ValidationException e){
            throw new IllegalStateException("Validation fail.", e);
        }
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        FieldFormat<T> fieldFormat = (FieldFormat<T>)o;
        return (name == fieldFormat.name || (name != null && name.equals(fieldFormat.getName())) )
                ||
                (description == fieldFormat.description || (description != null && description.equals(fieldFormat.getDescription())) )
                ||
                (nullable == fieldFormat.nullable || (nullable != null && nullable.equals(fieldFormat.getNullable())) )
                ||
                (hidden == fieldFormat.hidden || (hidden != null && hidden.equals(fieldFormat.getHidden())) )
                ||
                (defaultValue == fieldFormat.defaultValue || (defaultValue != null && defaultValue.equals(fieldFormat.getDefaultValue())) );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (nullable == null ? 0 : nullable.hashCode());
        result = prime * result + (hidden == null ? 0 : hidden.hashCode());
        result = prime * result + (defaultValue == null ? 0 : defaultValue.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = "name: " + (name == null ? "null" : name) + "; ";
        result += "description: " + (description == null ? "null" : description) + "; ";
        result += "nullable: " + (nullable == null ? "null" : nullable.toString()) + ";";
        result += "hidden: " + (hidden == null ? "null" : hidden.toString()) + ";";
        result += "default value: " + (defaultValue == null ? "null" : defaultValue.toString()) + ".";
        return result;
    }

    @Override
    public FieldFormat<T> clone() throws CloneNotSupportedException{
        return (FieldFormat<T>) super.clone();
    }
}
