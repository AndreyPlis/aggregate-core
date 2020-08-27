package com.tibbo.datatable;

public class LimitsFieldValidator {
    private Integer minValue;
    private Integer maxValue;

    public boolean valid(Integer value) {
       if(value == null || value < minValue || value > maxValue) {
           return false;
       }
       return true;
    }
}
