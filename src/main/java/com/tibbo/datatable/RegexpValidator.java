package com.tibbo.datatable;

import java.util.regex.Pattern;

public class RegexpValidator implements FieldValidator {
    private String regular;

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public RegexpValidator( String regular ){
        this.regular = regular;
    }

    @Override
    public boolean validate(FieldFormat value) {
        return Pattern.matches( regular, value.getValue( ).toString( ) );
    }
}
