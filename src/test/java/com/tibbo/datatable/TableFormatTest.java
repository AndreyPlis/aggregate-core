package com.tibbo.datatable;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TableFormatTest extends TestCase {

    public void testClone() {
        TableFormat tf = new TableFormat();
        tf.setMaxString(15);
        tf.setMinString(5);
        ArrayList<FieldFormat> myList = new ArrayList<>();
        myList.add(FieldFormatFactory.createFieldFormat('I', "kek",
                "lol", "12", false, false));
        myList.add(FieldFormatFactory.createFieldFormat('B', "kek",
                "lol", "true", false, false));
        tf.setFields(myList);
        TableFormat actual = tf.clone();
        assertEquals(tf, actual);

    }

    public void testEquals() {
        TableFormat tf = new TableFormat();
        tf.setMaxString(15);
        tf.setMinString(5);
        ArrayList<FieldFormat> myList = new ArrayList<>();
        myList.add(FieldFormatFactory.createFieldFormat('I', "kek",
                "lol", "12", false, false));
        myList.add(FieldFormatFactory.createFieldFormat('B', "kek",
                "lol", "true", false, false));
        myList.add(FieldFormatFactory.createFieldFormat('S', "kek",
                "lol", "thisString", false, false));
        tf.setFields(myList);
        TableFormat actual = tf.clone();
        assertEquals(true, tf.equals(actual));

    }

    public void testHashCode() {
        TableFormat tf = new TableFormat();
        tf.setMaxString(15);
        tf.setMinString(5);
        ArrayList<FieldFormat> myList = new ArrayList<>();
        myList.add(FieldFormatFactory.createFieldFormat('I', "kek",
                "lol", "12", false, false));
        myList.add(FieldFormatFactory.createFieldFormat('B', "kek",
                "lol", "true", false, false));
        myList.add(FieldFormatFactory.createFieldFormat('S', "kek",
                "lol", "thisString", false, false));
        tf.setFields(myList);
        TableFormat actual = tf.clone();
        assertEquals(tf.hashCode(), actual.hashCode());
        System.out.println(actual);

    }
}