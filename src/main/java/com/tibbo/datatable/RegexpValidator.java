package com.tibbo.datatable;

import java.util.regex.Pattern;

public class RegexpValidator<T> implements FieldValidator<T> {
    private String regular;

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public RegexpValidator( String regular ){
        this.regular = regular;
    }

    @Override
    public boolean validate(T value) {
        return Pattern.matches( regular, value.toString( ) );
    }
}
