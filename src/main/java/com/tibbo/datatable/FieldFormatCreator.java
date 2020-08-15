package com.tibbo.datatable;

public abstract class FieldFormatCreator {
    public abstract FieldFormat create(String... attr);

    public static FieldFormat setFields(FieldFormat ff, String... attr){
        switch (attr.length){
            case 5: ff.setDefaultValue(ff.valueFromString(attr[4]));
            case 4: ff.setHidden(new Boolean(attr[3]));
            case 3: ff.setNullable(new Boolean(attr[2]));
            case 2: ff.setDescription(attr[1]);
            case 1: ff.setName(attr[0]);
        }

        return ff;
    }
}
