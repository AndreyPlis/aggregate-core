package com.tibbo.datatable;

public class LengthFieldValidator<T> extends FieldValidator<T> {
    private final int lengthField;

    public LengthFieldValidator(int lengthField){
        this.lengthField = lengthField;
    }

    @Override
    public void validate(T value) {
        if (value.toString().length() > lengthField)
            throw new IllegalArgumentException(String.format("The field must not exceed %d characters",lengthField));
    }
}
