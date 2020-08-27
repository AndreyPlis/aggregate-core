package com.tibbo.datatable;

public class RegexFieldValidator {
    private String regex;

    public boolean valid(String value) {
       if(value == null) {
           return false;
       }
       return value.matches(regex);
    }
}
