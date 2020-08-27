package com.tibbo.datatable;

public class NullFieldValidator {

    public boolean valid(FieldFormat ff) {
        if(ff == null) {
            return false;
        }
        return true;
    }
}
