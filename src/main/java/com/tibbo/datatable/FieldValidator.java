package com.tibbo.datatable;

import java.util.List;
import java.util.regex.Pattern;

public class FieldValidator {

    public static boolean nullValidator( String value ) {
        return value == null;
    }

    public static boolean nullValidator( Integer value ) {
        return value == null;
    }

    public static boolean nullValidator( Boolean value ) {
        return value == null;
    }

    public static boolean limitsValidator( IntFieldFormat ff, int min, int max ) {
        if( ff.getValue( ) > max || ff.getValue( ) < min ) return false;
        return true;
    }

    public static boolean limitsValidator( StringFieldFormat ff, int min, int max ) {
        if( ff.getValue( ).length( ) > max || ff.getValue().length( ) < min ) return false;
        return true;
    }

    public static boolean regexpValidator( String value, String regular ) {
        return Pattern.matches( regular, value );
    }

    public static boolean regexpValidator( Integer value, String regular ) {
        return Pattern.matches( regular, value.toString( ) );
    }
}
