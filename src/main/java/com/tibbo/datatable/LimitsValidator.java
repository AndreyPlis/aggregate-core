package com.tibbo.datatable;

public class LimitsValidator implements FieldValidator{
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
    public boolean validate(FieldFormat value) {
        System.out.println( value.getValue( ).toString( ).length( ) );
        if( value.getValue( ).toString( ).length( ) > maxValue
                || value.getValue( ).toString( ).length( ) < minValue ) {
            return false;
        }
        return true;
    }
}
