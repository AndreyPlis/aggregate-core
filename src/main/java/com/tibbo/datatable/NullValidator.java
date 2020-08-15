package com.tibbo.datatable;

import java.util.regex.Pattern;

public class NullValidator implements FieldValidator {

    @Override
    public boolean validate( FieldFormat value ) {
        return value.getValue( ) == null;
    }
}
