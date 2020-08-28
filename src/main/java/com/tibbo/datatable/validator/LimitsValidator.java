package com.tibbo.datatable.validator;

import com.tibbo.datatable.*;

import java.text.*;
import java.util.*;

public class LimitsValidator implements FieldValidator {

    private Comparable min;
    private Comparable max;

    public LimitsValidator(Comparable min, Comparable max) {
        setLimits(min, max);
    }

    protected void setLimits(Comparable min, Comparable max) {
        if (min != null && max != null && !min.getClass().equals(max.getClass()))
            throw new IllegalStateException("'min' and 'max' Limits Validator parameters should be the same type");

        this.min = min;
        this.max = max;
    }


    @Override
    public void validate(Object value) throws ValidationException {
        if (value == null) {
            return;
        } else if (value instanceof String) {
            compare(value.toString().length());
        } else {
            if (!(value instanceof Comparable)) {
                throw new ValidationException("Value not comparable: " + value);
            }

            Comparable cv = (Comparable) value;

            compare(cv);
        }
    }

    private void compare(Comparable cv) throws ValidationException {
        if (min != null) {
            if (cv.compareTo(min) < 0) {
                throw new ValidationException(MessageFormat.format( "Value too small (current: {0}, min:{1})", cv, min));
            }
        }

        if (cv.compareTo(max) > 0) {
            throw new ValidationException(MessageFormat.format( "Value too big (current: {0}, max:{1})", cv, max));
        }
    }

    @Override
    public Character getType() {
        return FieldValidator.VALIDATOR_LIMITS;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LimitsValidator that = (LimitsValidator) o;
        return Objects.equals(min, that.min) &&
                Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
