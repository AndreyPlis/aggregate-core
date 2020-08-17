package com.tibbo.datatable;

public class  FieldFormatFactory {

    public static FieldFormat  createFieldFormat(Character type, String name, String description, String defaultValue,
                                             boolean nullable,  boolean hidden  ) {
        FieldFormat ff = null;
        if (type == FieldFormat.STRING_FIELD) {
            ff = new StringFieldFormat();
            ff.setDefaultValue(defaultValue.toString());
        } else if (type == FieldFormat.INTEGER_FIELD){
             ff = new IntFieldFormat();
            try
            {
                ff.setDefaultValue(Integer.parseInt (defaultValue));

            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
         }
        else {
            ff = new BooleanFieldFormat();
            ff.setDefaultValue(Boolean.parseBoolean(defaultValue));
        }
        ff.setName(name);
        ff.setDescription(description);
        ff.setNullable(nullable);
        ff.setHidden(hidden);
        return ff;
    }
}
