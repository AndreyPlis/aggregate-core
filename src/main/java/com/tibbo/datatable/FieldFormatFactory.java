package com.tibbo.datatable;

import javax.management.*;

public abstract class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = null;
        /*if (type == FieldFormat.STRING_FIELD)
            ff = new StringFieldFormat();
        else if (type == FieldFormat.INTEGER_FIELD)
            ff = new IntFieldFormat();
        ff.setName(name);
        ff.setDescription(description);
        return ff;*/

        switch (type){
            case FieldFormat.STRING_FIELD:
                ff = new StringFieldFormatCreator().create(name,description);
                break;
            case FieldFormat.INTEGER_FIELD:
                ff = new IntFieldFormatCreator().create(name,description);
                break;
            case FieldFormat.BOOLEAN_FIELD:
                ff = new BooleanFieldFormatCreator().create(name,description);
                break;
        }
        return ff;
    }
}
