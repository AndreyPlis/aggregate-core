package com.tibbo.datatable;

public class FieldValidatorNull implements FieldValidator {
    @Override
    public void validate(Object value) throws ValidationException {
    if (value == null){
        throw new ValidationException("value is null");
    }
    }
}
