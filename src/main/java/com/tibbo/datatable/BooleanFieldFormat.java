package com.tibbo.datatable;

public class BooleanFieldFormat extends FieldFormat<Boolean>{
    @Override
    public String valueToString(Boolean value) {
      return value.toString();
    }

    @Override
    public Boolean valueFromString(String value) {     //а это вообще правильно? зачем тут этот метод если и должен быть то должен быть void и сетить значение из строки????

        return Boolean.valueOf(value);
    }

    @Override
    public char getType () { return FieldFormat.BOOLEAN_FIELD; }
}
