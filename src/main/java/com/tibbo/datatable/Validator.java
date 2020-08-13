package com.tibbo.datatable;

public interface Validator<T> {
    boolean isValid(T value);

    void getErrorMessage();

    void Validation(T value);
}
