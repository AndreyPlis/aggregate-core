package com.tibbo.datatable.validator;

import com.tibbo.datatable.*;

import java.text.*;
import java.util.*;
import java.util.regex.*;

public class RegexValidator implements FieldValidator {

    private final String regex;

    public RegexValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public void validate(Object value) throws ValidationException {
        try {
            if (value != null && !value.toString().matches(regex)) {
                throw new ValidationException(MessageFormat.format("Value ''{0}'' does''t match to pattern ''{1}''", value, regex));
            }
        } catch (PatternSyntaxException ex) {
            throw new ValidationException(ex.getMessage(), ex);
        }

    }

    @Override
    public Character getType() {
        return FieldValidator.VALIDATOR_REGEX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegexValidator that = (RegexValidator) o;
        return Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regex);
    }
}
