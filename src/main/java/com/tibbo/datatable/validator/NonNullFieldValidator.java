package com.tibbo.datatable.validator;

import com.tibbo.datatable.*;
import com.tibbo.datatable.validator.*;

public class NonNullFieldValidator implements FieldValidator {
    @Override
    public void validate(Object value) throws ValidationException {
        if(value == null)
            throw new ValidationException("value must not be null");
    }

    @Override
    public Character getType() {
        return FieldValidator.VALIDATOR_NON_NULL;
    }
}
