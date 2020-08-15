package com.tibbo.datatable;

public class FieldFormatFactory {

    public static FieldFormat createFieldFormat(Character type, String name, String description) {
        FieldFormat ff = null;
        switch (type) {
            case FieldFormat.STRING_FIELD:
            {
                ff = new StringFieldFormat();
                ff.setDefaultValue( "text" );
                break;
            }
            case FieldFormat.INTEGER_FIELD:
            {
                ff = new IntFieldFormat();
                ff.setDefaultValue( 1 );
                break;
            }
            case FieldFormat.BOOLEAN_FIELD:
            {
                ff = new BooleanFieldFormat();
                ff.setDefaultValue( true );
                break;
            }
        }
        ff.setName(name);
        ff.setDescription(description);
        return ff;
    }
}
