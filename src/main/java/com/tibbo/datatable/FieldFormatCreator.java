package com.tibbo.datatable;

public abstract class FieldFormatCreator {
    public abstract FieldFormat create(String... attr);

    public static FieldFormat setFields(FieldFormat ff, String... attr){
        if(attr.length > 0){
            ff.setName(attr[0]);
            if(attr.length > 1){
                ff.setDescription(attr[1]);
                if(attr.length > 2){
                    ff.setNullable(new Boolean(attr[2]));
                }
            }
        }

        return ff;
    }
}
