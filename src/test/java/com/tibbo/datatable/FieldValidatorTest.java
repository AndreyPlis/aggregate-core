package com.tibbo.datatable;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class FieldValidatorTest extends TestCase {

    public void testCheckValid() {
        BooleanFieldFormat actual = ( BooleanFieldFormat ) FieldFormatFactory.createFieldFormat('B', "kek",
                "lol", "true", false, false);
        assertEquals(false, FieldValidator.checkValid(actual));
        actual = ( BooleanFieldFormat ) FieldFormatFactory.createFieldFormat('B', "kekkek",
                "lol", "true", false, false);
        assertEquals(true, FieldValidator.checkValid(actual));

    }

}