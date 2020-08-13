package com.tibbo.datatable;

import java.util.ArrayList;

public class FieldValidator implements Validator<FieldFormat<?>> {

    private final ArrayList<String> errorMessage = new ArrayList<>();

    public void Validation(FieldFormat<?> value) {
        FieldValidator fieldValidator = new FieldValidator();
        if (fieldValidator.isValid(value)) {
            System.out.println("Ok");
        } else {
            fieldValidator.getErrorMessage();
        }
    }

    @Override
    public boolean isValid(FieldFormat<?> value) {
        if (value == null) {
            errorMessage.add("FieldFormat must not be null");
        }

        final String name = value.getName();
        if (name == null) {
            errorMessage.add("Name must not be null");
        }
        final String description = value.getDescription();
        if (description == null) {
            errorMessage.add("Description must not be null");
        }
        final Boolean nullable = value.getNullable();
        if (nullable == null) {
            errorMessage.add("Nullable must not be null");
        }
        final Boolean hidden = value.getHidden();
        if (hidden == null) {
            errorMessage.add("Hidden must not be null");
        }
        final String defaultValue = value.getDefaultValue();
        if (defaultValue == null) {
            errorMessage.add("DefaultValue must not be null");
            return false;
        }
        return true;
    }


    @Override
    public void getErrorMessage() {
        for (String s : errorMessage)
            System.out.println(s);
    }
}
