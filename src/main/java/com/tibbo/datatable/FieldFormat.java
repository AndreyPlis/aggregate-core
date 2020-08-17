package com.tibbo.datatable;

public abstract class FieldFormat<T> implements Cloneable{
    private String name;
    private String description;
    private Boolean nullable;
    private Boolean hidden = false;
    private T defaultValue;

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


    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }


    public Boolean getHidden() {
        return hidden;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    @Override
    public boolean equals(Object o) {
            if(this == o){
                return true;
            }
            if(o == null || this.getClass() != o.getClass() ){
                return false;
            }
        FieldFormat fieldFormat = (FieldFormat) o;
            if(name != fieldFormat.name && description != fieldFormat.description && nullable != fieldFormat.nullable
            && hidden!= fieldFormat.hidden && defaultValue != fieldFormat.defaultValue){
                return false;
            }
            return  true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode() * 29;
        result += description.hashCode() * 29;
        result += nullable.hashCode() * 29;
        result += hidden.hashCode() * 29;
        result += defaultValue.hashCode() * 29;
        return result;
    }

    @Override
    public String toString() {
        return "FieldFormat [name=" + name
                + ", description=" + description
                + ", nullable=" + nullable.toString()
                + " hidden=" + hidden.toString()
                + " defaultValue=" + defaultValue.toString() + "]";
    }
    @Override
    public  abstract  FieldFormat clone();


}
