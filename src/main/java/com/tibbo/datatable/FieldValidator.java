package com.tibbo.datatable;

import java.util.List;
import java.util.regex.Pattern;

public interface FieldValidator<T> {

    public boolean validate( T value ) throws ExceptionValidator;
}
