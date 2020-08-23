package com.tibbo.datatable;

public abstract class FieldValidator<T> implements Validator<T>{

    @Override
    public abstract void validate(T value) throws ValidationException;

}
