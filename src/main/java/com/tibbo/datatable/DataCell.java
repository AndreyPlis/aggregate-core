package com.tibbo.datatable;

public class DataCell<T> {
    private char type;
    private String name;
    private T value;

    public char getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DataCell(char type, String name, T value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }
}
