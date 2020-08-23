package com.tibbo.datatable;

public class LengthFieldValidator<T> extends FieldValidator<T> {
    private int lengthField;

    public LengthFieldValidator(int lengthField) {
        this.lengthField = lengthField;
    }

    @Override
    public void validate(T value) throws ValidationException {
        if(value.toString().length() > lengthField)
            throw new IllegalArgumentException("The field is too long");
    }
}
