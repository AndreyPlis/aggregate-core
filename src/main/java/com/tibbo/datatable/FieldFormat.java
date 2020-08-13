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
        //Remove placeholder: throw new UnsupportedOperationException();
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
                (nullable == fieldFormat.nullable || (nullable != null && nullable.equals(fieldFormat.getNullable())) );
    }

    @Override
    public int hashCode() {
        //I think, it was placeholder too: throw new UnsupportedOperationException();
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (nullable == null ? 0 : nullable.hashCode());
        return result;
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException();
        String result;
        result = "name: " + (name == null ? "null" : name) + "; ";
        result += "description: " + (description == null ? "null" : description) + "; ";
        result += "nullable: " + (nullable == null ? "null" : nullable.toString()) + ".";
        return result;
    }

    @Override
    public FieldFormat<T> clone() throws CloneNotSupportedException{
        return (FieldFormat<T>) super.clone();
    }
}
