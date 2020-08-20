package com.tibbo.datatable;

public interface Validator<T> {
    void validate(T value) throws ValidationException;

}
