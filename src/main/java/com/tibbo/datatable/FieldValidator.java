package com.tibbo.datatable;

public interface FieldValidator<T> {
    void validate(T value) throws ValidationException;
}
