package com.tibbo.datatable;

import javax.management.*;

public abstract class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String... attr) {
        FieldFormat ff = null;

        switch (type){
            case FieldFormat.STRING_FIELD:
                ff = new StringFieldFormatCreator().create(attr);
                break;
            case FieldFormat.INTEGER_FIELD:
                ff = new IntFieldFormatCreator().create(attr);
                break;
            case FieldFormat.BOOLEAN_FIELD:
                ff = new BooleanFieldFormatCreator().create(attr);
                break;
        }
        return ff;
    }
}
