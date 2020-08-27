import com.tibbo.datatable.field.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldFormatTest {


    @Test
    public void createStringFieldFormat() {
        StringFieldFormat ff = new StringFieldFormat();
        assertEquals(FieldFormat.STRING_FIELD,ff.getType());
    }

    @Test
    public void createStringFieldFormatFromFactory() {

    }


    //Boolean
    @Test
    public void createBooleanFieldFormat() {
        BooleanFieldFormat ff = new BooleanFieldFormat();
        assertEquals(FieldFormat.BOOLEAN_FIELD,ff.getType());
    }

    @Test
    public void createBooleanFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "bool1", "DescrOfBool1");
        assertEquals(FieldFormat.BOOLEAN_FIELD, ff.getType());
        assertEquals("bool1", ff.getName());
        assertEquals("DescrOfBool1", ff.getDescription());
    }

    // convert to and from string
    @Test
    public void convertStringToFrom(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1");
        assertEquals("TestValue", ff.valueToString("TestValue"));
        assertEquals("SecondTest", ff.valueFromString("SecondTest"));
    }

    @Test
    public void convertIntegerToFrom(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1");
        assertEquals("1234", ff.valueToString(new Integer(1234)));
        assertEquals(new Integer(7890), ff.valueFromString("7890"));
    }

    @Test
    public void convertBooleanToFrom(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "bool1", "DescrOfBool1");
        assertEquals("false", ff.valueToString(new Boolean("test")));
        assertEquals("true", ff.valueToString(new Boolean("true")));
        assertEquals(false, ff.valueFromString("7890"));
    }

    //clone
    @Test
    public void cloneString(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1");

            FieldFormat f3 = ff.clone();
            assertTrue( f3.equals(ff));

    }

    @Test
    public void cloneInteger(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1");

            FieldFormat f3 = ff.clone();
            assertTrue( f3.equals(ff));

    }

    @Test
    public void cloneBoolean(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "bool1", "DescrOfBool1");
           FieldFormat f3 = ff.clone();
            assertTrue( f3.equals(ff));

    }

    //hashcode equals
    @Test
    public void equalsHashCodeString(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1");
        FieldFormat f2 = ff;
        assertTrue( f2.equals(ff));
        assertEquals(-270744153, ff.hashCode());
        assertEquals(ff.hashCode(), f2.hashCode());
    }

    @Test
    public void equalsHashCodeInteger(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1");
        FieldFormat f2 = ff;
        assertTrue( f2.equals(ff));
        assertEquals(-571929241, ff.hashCode());
        assertEquals(ff.hashCode(), f2.hashCode());
    }

    @Test
    public void equalsHashCodeBoolean(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "bool1", "DescrOfBool1");
        FieldFormat f2 = ff;
        assertTrue( f2.equals(ff));
        assertEquals(1652822839, ff.hashCode());
        assertEquals(ff.hashCode(), f2.hashCode());
    }

}
