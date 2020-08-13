import com.tibbo.datatable.*;
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
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1");
        assertEquals(FieldFormat.STRING_FIELD, ff.getType());
        assertEquals("str1", ff.getName());
        FieldFormat f2 = ff;
        assertEquals(true, f2.equals(ff));
        try {
            FieldFormat f3 = ff.clone();
            assertEquals(true, f3.equals(ff));
        }catch (CloneNotSupportedException cloneEx) {
            cloneEx.printStackTrace();
        }
    }

    @Test
    public void createIntFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1");
        assertEquals(FieldFormat.INTEGER_FIELD, ff.getType());
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

    //clone
    @Test
    public void cloneString(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "str1", "DescrOfStr1");
        try {
            FieldFormat f3 = ff.clone();
            assertTrue( f3.equals(ff));
        }catch (CloneNotSupportedException cloneEx) {
            cloneEx.printStackTrace();
        }
    }

    @Test
    public void cloneInteger(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "int1", "DescrOfInt1");
        try {
            FieldFormat f3 = ff.clone();
            assertTrue( f3.equals(ff));
        }catch (CloneNotSupportedException cloneEx) {
            cloneEx.printStackTrace();
        }
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
}
