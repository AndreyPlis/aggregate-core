import com.tibbo.datatable.*;
import org.junit.*;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.*;

public class FieldFormatTest {
    private final FieldFormat<String> stringFieldFormat = new StringFieldFormat();
    private final FieldFormat<Integer> intFieldFormat = new IntFieldFormat();
    private final FieldFormat<Boolean> booleanFieldFormat = new BooleanFieldFormat();


    @Test
    public void createFieldFormat() {
        assertEquals(FieldFormat.STRING_FIELD, stringFieldFormat.getType());
        assertEquals(FieldFormat.INTEGER_FIELD, intFieldFormat.getType());
        assertEquals(FieldFormat.BOOLEAN_FIELD, booleanFieldFormat.getType());
    }

    @Test
    public void createFieldFormatFromFactory() {
        FieldFormat<?> fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD);
        FieldFormat<?> fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD);
        FieldFormat<?> fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD);
        assertEquals(FieldFormat.STRING_FIELD, fieldFormat.getType());
        assertEquals(FieldFormat.INTEGER_FIELD, fieldFormat1.getType());
        assertEquals(FieldFormat.BOOLEAN_FIELD, fieldFormat2.getType());
    }

    @Test
    public void checkConvertToString() {
        assertEquals("Hello", stringFieldFormat.valueToString("Hello"));
        assertEquals("10", intFieldFormat.valueToString(10));
        assertEquals("false", booleanFieldFormat.valueToString(false));
    }

    @Test
    public void checkConvertFromString() {
        assertEquals("Hello", stringFieldFormat.valueFromString("Hello"));
        assertEquals(Integer.valueOf(10), intFieldFormat.valueFromString("10"));
        assertEquals(false, booleanFieldFormat.valueFromString("false"));
    }

    @Test
    public void checkCloneMethod() {
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
        FieldFormat<String> stringFieldFormat1 = new StringFieldFormat();

        assertEquals(stringFieldFormat.hashCode(), stringFieldFormat1.hashCode());
        stringFieldFormat1.setName("Alex");
        assertNotEquals(stringFieldFormat.hashCode(), stringFieldFormat1.hashCode());
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalcListenerFieldFormat());
        core.run(FieldFormatTest.class);
    }

}

class CalcListenerFieldFormat extends RunListener {
    @Override
    public void testStarted(Description description) {
        System.out.println("Started:" + description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) {
        System.out.println("Finished:" + description.getDisplayName());
    }

    @Override
    public void testFailure(Failure failure) {
        System.out.println("Failed:" + failure.getDescription().getDisplayName() + " [" + failure.getMessage() + "]");
    }

}
