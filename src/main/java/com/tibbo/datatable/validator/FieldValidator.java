package com.tibbo.datatable.validator;

import com.tibbo.datatable.*;

public interface FieldValidator {

    char VALIDATOR_LIMITS = 'L';
    char VALIDATOR_REGEX = 'R';
    char VALIDATOR_NON_NULL = 'N';

    void validate(Object value) throws ValidationException;

    Character getType();
}
