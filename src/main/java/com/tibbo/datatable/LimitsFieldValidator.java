package com.tibbo.datatable;

import java.util.*;

public class LimitsFieldValidator<T extends Comparable<T>> implements FieldValidator<T>{
    private T minValue;
    private T maxValue;

    public T getMinValue() {
        return minValue;
    }

    public void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

    public LimitsFieldValidator(T minValue, T maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void validate(T value) throws ValidateException{
       if( value==null || value.compareTo(minValue) < 0 || value.compareTo(maxValue) > 0) {
           throw new ValidateException("limits exceeded");
       }
       
    }
}
