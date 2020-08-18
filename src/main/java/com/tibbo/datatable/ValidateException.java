package com.tibbo.datatable;

public class ValidateException extends Exception {
    public ValidateException(String description) {
        throw new IllegalStateException(description, this);
    }
}
