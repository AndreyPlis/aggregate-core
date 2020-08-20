package com.tibbo.datatable;

public class RegexFieldValidator<T> implements FieldValidator<T>{
    private String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public boolean valid(String value) {
       if(value == null) {
           return false;
       }
       return value.matches(regex);
    }

    @Override
    public void validate(T value) throws ValidateException {
        if(value == null || !value.toString().matches(regex) )
            throw new ValidateException("Doesn't match regular expression");
    }

    @Override
    public RegexFieldValidator<T> clone() throws CloneNotSupportedException{
        return (RegexFieldValidator<T>) super.clone();
    }
}
