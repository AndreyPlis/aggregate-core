package com.tibbo.datatable;

public interface Validator {
    <T> void nullFieldValidator(T value);

    void limitsValidator(int value);

    void regexValidation(String value);

    void lengthFieldValidator(String value);
}
