import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;

import java.lang.annotation.*;

public class FieldFormatTest {

    @Test
    public void createStringFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1", true, false);
        assertEquals(FieldFormat.STRING_FIELD, ff.getType());
        assertEquals("str1", ff.getName());
        assertEquals("DescrOfStr1", ff.getDescription());
        assertTrue(ff.getNullable());
        assertFalse(ff.getHidden());
        assertNull(ff.getDefaultValue());
    }

    @Test
    public void createIntFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1", false, false, 1234);
        assertEquals(FieldFormat.INTEGER_FIELD, ff.getType());
        assertEquals("int1", ff.getName());
        assertEquals("DescrOfInt1", ff.getDescription());
        assertFalse(ff.getNullable());
        assertFalse(ff.getHidden());
        assertEquals(1234, ff.getDefaultValue());
    }

    @Test
    public void validateField(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "Descr Of str1", false, false, "Hi all!");
        ff.addValidator(new RegexFieldValidator("[a-z]+"));
        try {
            ff.validate("testvalue");
        }
        catch (ValidateException e){
            System.out.println("First regex validation failed");
        }
        try {
            ff.validate("123 456");
        }
        catch (ValidateException e){
            System.out.println("Second regex validation failed");
        }
    }
    @Test
    public void createTableFormat(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "Descr Of str1", false, false, "hi all!");
        ff.addValidator(new RegexFieldValidator("[a-z]+"));
        TableFormat tf = new TableFormat();
        tf.addField(ff);
        assertEquals(1, tf.getFieldsSize());
        assertFalse(tf.isFieldNullable(0));
        tf.addField(FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "", true, false, 56));
        assertEquals(2, tf.getFieldsSize());
        assertEquals(FieldFormat.INTEGER_FIELD, tf.getFieldType(1));
    }

    @Test
    public void createDataRecord(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "Descr Of str1", false, false, "hi all!");
        TableFormat tf = new TableFormat();
        tf.addField(ff);
        tf.addField(FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "", true, false, 56));
        DataRecord dr = new DataRecord(tf);
        assertEquals("hi all!", dr.getFieldValue(0));
        dr.setFieldValue(0, "Next string");
        assertEquals("Next string", dr.getFieldValue(0));
    }
}
