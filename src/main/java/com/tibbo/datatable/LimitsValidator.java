package com.tibbo.datatable;

public class LimitsValidator<T> extends FieldValidator<T> {
    private final int startValueLimits;
    private final int endValueLimits;

    public LimitsValidator(int startValueLimits, int endValueLimits) {
        this.startValueLimits = startValueLimits;
        this.endValueLimits = endValueLimits;
    }

    @Override
    public void isValid(T value) {
        if ((Integer) value <= startValueLimits || (Integer) value >= endValueLimits) {
            throw new IllegalArgumentException(String.format("Value must be between %d and %d", startValueLimits, endValueLimits));
        }
    }
}
