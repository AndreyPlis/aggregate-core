package com.tibbo.datatable;

import java.util.ArrayList;

public class TableValidator implements Validator<TableFormat> {

    private final ArrayList<String> errorMessage = new ArrayList<>();

    public void Validation(TableFormat value) {
        TableValidator tableValidator = new TableValidator();
        if (tableValidator.isValid(value)) {
            System.out.println("Ok");
        } else {
            tableValidator.getErrorMessage();
        }
    }

    @Override
    public boolean isValid(TableFormat value) {
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

        return true;
    }


    @Override
    public void getErrorMessage() {
        for (String s : errorMessage)
            System.out.println(s);
    }
}
