package com.tibbo.datatable;

import java.util.ArrayList;

public class TableValidator implements Validator {
    @Override
    public <T> void nullFieldValidator(T value) {

    }

    @Override
    public void limitsValidator(int value) {

    }

    @Override
    public  void regexValidation(String value) {

    }

    @Override
    public void lengthFieldValidator(String value) {

    }

    //    private final ArrayList<String> errorMessage = new ArrayList<>();
//
//    public void validation(TableFormat value) {
//        TableValidator tableValidator = new TableValidator();
//        if (tableValidator.isValid(value)) {
//            System.out.println("Ok");
//        } else {
//            tableValidator.getErrorMessage();
//        }
//    }
//
//    @Override
//    public void isValid(TableFormat value) {
//        if (value == null) {
//            errorMessage.add("FieldFormat must not be null");
//        }
//        final Integer maxCountField = value.getMaxCountField();
//        if (maxCountField == null) {
//            errorMessage.add("maxCountField must not be null");
//        }
//        final Integer minCountField = value.getMinCountField();
//        if (minCountField == null) {
//            errorMessage.add("minCountField must not be null");
//            return false;
//        }
//    }
//
//
//    @Override
//    public void getErrorMessage() {
//        for (String s : errorMessage)
//            System.out.println(s);
//    }
//    public static <T> void nullFieldValidator(T value) {
//        if (value == null)
//            throw new NullPointerException("Значение не может быть равно нулю");
//    }
}
