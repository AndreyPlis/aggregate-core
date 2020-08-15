package com.tibbo.datatable;

import java.util.List;
import java.util.regex.Pattern;

public interface FieldValidator {
    public boolean validate( FieldFormat value );
}
