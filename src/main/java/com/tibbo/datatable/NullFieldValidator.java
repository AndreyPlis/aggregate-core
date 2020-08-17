package com.tibbo.datatable;

public class NullFieldValidator extends FieldValidator{

    public boolean valid(FieldFormat ff) {
        if(ff == null) {
            return false;
        }
        return true;
    }
}
