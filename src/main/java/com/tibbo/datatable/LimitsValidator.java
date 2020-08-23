package com.tibbo.datatable;

public class LimitsValidator<T> extends FieldValidator<T> {
    private final int startValueLimits;
    private final int endValueLimits;

    public LimitsValidator(int startValueLimits, int endValueLimits) {
        this.startValueLimits = startValueLimits;
        this.endValueLimits = endValueLimits;
    }

    @Override
    public void validate(T value) throws ValidationException {
        if((int)value <= startValueLimits || (int) value>= endValueLimits){
            throw new IllegalArgumentException("The value must be different");
        }
    }
}
