package com.tibbo.datatable;

public class NullFieldValidator<T> implements FieldValidator<T> {
    @Override
    public void validate(T value) throws ValidateException {
        if(value == null)
            throw new ValidateException("value must not be null");
    }
}
