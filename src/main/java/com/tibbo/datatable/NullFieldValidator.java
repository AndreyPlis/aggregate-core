package com.tibbo.datatable;

public class NullFieldValidator<T> implements FieldValidator<T> {
    @Override
    public void validate(T value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("value cannot be null");
        }
    }
}
