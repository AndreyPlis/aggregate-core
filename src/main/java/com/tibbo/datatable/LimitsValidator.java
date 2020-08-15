package com.tibbo.datatable;

public class LimitsValidator<T> implements FieldValidator<T>{
    private int minValue = 0;
    private int maxValue = 0;

    public LimitsValidator( int minValue, int maxValue ){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public boolean validate(T value) {
        if( value.toString( ).length( ) > maxValue || value.toString( ).length( ) < minValue ) {
            return false;
        }
        return true;
    }
}
