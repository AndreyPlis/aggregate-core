package com.tibbo.datatable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator<T> extends FieldValidator<T> {
    private final String regex;

    public RegexValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public void isValid(T value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((String) value);
        if (!matcher.find())
            throw new IllegalArgumentException(String.format("String does not match pattern: %s", regex));
    }
}
