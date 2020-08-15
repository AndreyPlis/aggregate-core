package com.tibbo.datatable;

public abstract class Validators implements Validator{

    @Override
    public abstract  <T> void nullFieldValidator(T value);

    @Override
    public abstract void limitsValidator(int value);

    @Override
    public abstract void regexValidation(String value);

    @Override
    public abstract void lengthFieldValidator(String value);
}
