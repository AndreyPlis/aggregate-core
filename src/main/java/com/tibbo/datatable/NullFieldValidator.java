package com.tibbo.datatable;

public class NullFieldValidator<T> extends FieldValidator<T> {

    @Override
    public void isValid(T value) {
        if (value == null)
            throw new NullPointerException("The value don't must be null");
    }
}
