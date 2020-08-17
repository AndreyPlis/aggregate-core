import com.tibbo.datatable.*;
import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class FieldFormatTest {

    @Test
    public void createStringFieldFormat() {
        StringFieldFormat ff = new StringFieldFormat();
        assertEquals(FieldFormat.STRING_FIELD,ff.getType());
    }

    @Test
    public void createStringFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "K1ZO", "String Field", true);
        assertEquals(FieldFormat.STRING_FIELD, ff.getType());
    }

    @Test
    public void createIntFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "K1ZO", "Int Field", true);
        assertEquals(FieldFormat.INTEGER_FIELD, ff.getType());
    }

    @Test
    public void createBooleanFieldFormatFromFactory(){
        FieldFormat ff = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "K1ZO", "Boolean Field", true);
    }

    @Test
    public void convertToString(){
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        assertEquals("Hi, im K1ZO", stringFieldFormat.valueFromString("Hi, im K1ZO"));

        FieldFormat<Integer> integerFieldFormat = new IntFieldFormat();
        assertEquals("15092002", integerFieldFormat.valueToString(15092002));

        FieldFormat<Boolean> booleanFieldFormat = new BooleanFieldFormat();
        assertEquals("true", booleanFieldFormat.valueToString(true));
    }

    @Test
    public void convertFromString(){
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        assertEquals("Hello, im K1ZO", stringFieldFormat.valueFromString("Hello, im K1ZO"));

        FieldFormat<Integer> integerFieldFormat = new IntFieldFormat();
        assertEquals(Integer.valueOf(15092002), integerFieldFormat.valueFromString("15092002"));

        //boolean test FF
    }

    @Test
    public void checkClone(){
        FieldFormat<String> stringFieldFormat = new StringFieldFormat();
        stringFieldFormat.setName("K1ZO");
        stringFieldFormat.setDescription("Learning JAVA");
        stringFieldFormat.setNullable(false);

        FieldFormat<?> fieldFormatCheckClone = stringFieldFormat.clone();

        assertEquals(fieldFormatCheckClone, stringFieldFormat);
        assertEquals(fieldFormatCheckClone.getName(), stringFieldFormat.getName());
        assertEquals(fieldFormatCheckClone.getDescription(), stringFieldFormat.getDescription());
        assertEquals(fieldFormatCheckClone.getNullable(), stringFieldFormat.getNullable());
    }

    @Test
    public void checkEquals() {
        FieldFormat<?> testStringFF = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "K1ZO", "Im K1ZO", true);
        FieldFormat<?> testStringFFTwo = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "K1ZO", "Im K1ZO", true);

        assertEquals( true, testStringFF.equals(testStringFFTwo) & testStringFFTwo.equals(testStringFF));

        testStringFF.setDescription("Im bot");
        assertEquals(false, testStringFF.equals(testStringFFTwo) & testStringFFTwo.equals(testStringFF));
    }

    @Test
    public void checkHashCode(){
        FieldFormat<?> testIntFF = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "K1ZO","This HashCode check", true);
        FieldFormat<?> testIntFFTwo = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD,"K1ZO","This HashCode check", true);

        assertEquals(true, testIntFF.hashCode() == testIntFFTwo.hashCode());

        testIntFFTwo.setName("K1ZOO");
        assertEquals(false, testIntFF.hashCode() == testIntFFTwo.hashCode());
    }

}
