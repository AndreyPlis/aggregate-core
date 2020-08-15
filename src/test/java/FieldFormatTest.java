import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldFormatTest {

    @Test
    public void createFieldFormat() {
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        FieldFormat<Integer> intFieldFormat = new IntFieldFormat();
        FieldFormat<Boolean> booleanFieldFormat = new BooleanFieldFormat();

        assertEquals(FieldFormat.STRING_FIELD, stringFieldFormat.getType());
        assertEquals(FieldFormat.INTEGER_FIELD, intFieldFormat.getType());
        assertEquals(FieldFormat.BOOLEAN_FIELD, booleanFieldFormat.getType());
    }

    @Test
    public void createFieldFormatFromFactory() {
        FieldFormat<?> fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "First", "0", true, false, "Second");
        FieldFormat<?> fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "First", "0", true, false, "Second");
        FieldFormat<?> fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "First", "0", true, false, "Second");

        assertEquals(FieldFormat.STRING_FIELD, fieldFormat.getType());
        assertEquals(FieldFormat.INTEGER_FIELD, fieldFormat1.getType());
        assertEquals(FieldFormat.BOOLEAN_FIELD, fieldFormat2.getType());
    }

    @Test
    public void checkConvertToString() {
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        FieldFormat<Integer> intFieldFormat = new IntFieldFormat();
        FieldFormat<Boolean> booleanFieldFormat = new BooleanFieldFormat();

        assertEquals("Hello", stringFieldFormat.valueToString("Hello"));
        assertEquals("10", intFieldFormat.valueToString(10));
        assertEquals("false", booleanFieldFormat.valueToString(false));
    }

    @Test
    public void checkConvertFromString() {
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        FieldFormat<Integer> intFieldFormat = new IntFieldFormat();
        FieldFormat<Boolean> booleanFieldFormat = new BooleanFieldFormat();

        assertEquals("Hello", stringFieldFormat.valueFromString("Hello"));
        assertEquals(Integer.valueOf(10), intFieldFormat.valueFromString("10"));
        assertEquals(false, booleanFieldFormat.valueFromString("false"));
    }

    @Test
    public void checkCloneMethod() {
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        stringFieldFormat.setName("First");
        stringFieldFormat.setDefaultValue("0");
        stringFieldFormat.setHidden(true);
        stringFieldFormat.setNullable(false);
        stringFieldFormat.setDescription("Second");
        FieldFormat<?> fieldFormatClone = stringFieldFormat.clone();

        assertEquals(fieldFormatClone, stringFieldFormat);
        assertEquals(fieldFormatClone.getName(), stringFieldFormat.getName());
        assertEquals(fieldFormatClone.getDescription(), stringFieldFormat.getDescription());
        assertEquals(fieldFormatClone.getDefaultValue(), stringFieldFormat.getDefaultValue());
        assertEquals(fieldFormatClone.getHidden(), stringFieldFormat.getHidden());
        assertEquals(fieldFormatClone.getNullable(), stringFieldFormat.getNullable());
    }

    @Test
    public void checkEqualsMethod() {
        FieldFormat<?> stringFieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "First", "0", true, false, "Second");
        FieldFormat<?> stringFieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "First", "0", true, false, "Second");

        assertEquals(stringFieldFormat2, stringFieldFormat1);
        stringFieldFormat2.setName("Second");
        assertNotEquals(stringFieldFormat2, stringFieldFormat1);
    }

    @Test
    public void checkHashCodeMethod() {
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        FieldFormat<String> stringFieldFormat1 = new StringFieldFormat();

        assertEquals(stringFieldFormat.hashCode(), stringFieldFormat1.hashCode());
        stringFieldFormat1.setName("Alex");
        assertNotEquals(stringFieldFormat.hashCode(), stringFieldFormat1.hashCode());
    }
}
