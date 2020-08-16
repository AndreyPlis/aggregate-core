package com.tibbo.datatable;

public abstract class FieldValidator<T> implements Validator<T>{

    @Override
    public abstract void isValid(T value);

}
