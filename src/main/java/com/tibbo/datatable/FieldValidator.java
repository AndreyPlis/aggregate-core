package com.tibbo.datatable;


    public class FieldValidator {
        public static boolean checkValid(FieldFormat fieldFormat) {
            if (fieldFormat.getNullable() == true) {
                if (fieldFormat.getName() == "" || fieldFormat.getDescription() == "" || fieldFormat.getDefaultValue() == "")
                    return false;
            }
            if (fieldFormat.getName().length() < 4 || fieldFormat.getName().length() > 15) return false;
            if (fieldFormat.getDescription().length() > 50) return false;
            return true;
        }
    }
