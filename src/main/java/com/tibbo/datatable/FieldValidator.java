package com.tibbo.datatable;

public interface FieldValidator<T> {
    public void validate(T value) throws ValidateException;
}
