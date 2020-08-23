package com.tibbo.datatable;

import java.util.regex.Pattern;

public class NullValidator<T> implements FieldValidator<T> {

    @Override
    public boolean validate( T value ) throws ExceptionValidator  {
        return value == null;
    }
}
