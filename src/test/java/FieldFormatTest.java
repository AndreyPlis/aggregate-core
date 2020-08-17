import com.tibbo.datatable.BooleanFieldFormat;
import com.tibbo.datatable.FieldFormatFactory;
import com.tibbo.datatable.IntFieldFormat;
import com.tibbo.datatable.StringFieldFormat;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldFormatTest {

   /* @Test
    public void createStringFieldFormat() {
        StringFieldFormat ff = new StringFieldFormat();
        assertEquals(FieldFormat.STRING_FIELD,ff.getType());
    }*/

    @Test
    public void createStringFieldFormatFromFactory() {
        StringFieldFormat ff = new StringFieldFormat();
        ff.setName("kek");
        ff.setDescription("lol");
        ff.setDefaultValue("12");
        ff.setHidden(false);
        ff.setNullable(false);
        StringFieldFormat actual = null;
        actual = (StringFieldFormat) FieldFormatFactory.createFieldFormat('S', "kek",
                "lol", "12", false, false);
        assertEquals(true, ff.equals(actual));
    }

   @Test
    public void createIntFieldFormatFromFactory() {
        IntFieldFormat ff = new  IntFieldFormat();
        ff.setName("kek");
        ff.setDescription("lol");
        ff.setDefaultValue(12);
        ff.setHidden(false);
        ff.setNullable(false);
        IntFieldFormat  actual = null;
        actual = ( IntFieldFormat ) FieldFormatFactory.createFieldFormat('I', "kek",
                "lol", "12", false, false);
        assertEquals(true, ff.equals(actual));

    }
    public void createBooleanFieldFormatFromFactory(){
        BooleanFieldFormat ff = new  BooleanFieldFormat();
        ff.setName("kek");
        ff.setDescription("lol");
        ff.setDefaultValue(true);
        ff.setHidden(false);
        ff.setNullable(false);
        BooleanFieldFormat  actual = null;
        actual = ( BooleanFieldFormat ) FieldFormatFactory.createFieldFormat('B', "kek",
                "lol", "true", false, false);
        assertEquals(true, ff.equals(actual));
    }

    @Test
    public void valueToString() {
    }

    @Test
    public void valueFromString() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void getNullable() {
    }

    @Test
    public void setNullable() {
    }

    @Test
    public void setHidden() {
    }

    @Test
    public void setDefaultValue() {
    }

    @Test
    public void getHidden() {
    }

    @Test
    public void getDefaultValue() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
        IntFieldFormat ff = new  IntFieldFormat();
        ff.setName("kek");
        ff.setDescription("lol");
        ff.setDefaultValue(12);
        ff.setHidden(false);
        ff.setNullable(false);
        IntFieldFormat  actual = null;
        actual = ( IntFieldFormat ) FieldFormatFactory.createFieldFormat('I', "kek",
                "lol", "12", false, false);
        assertEquals(ff.hashCode(), actual.hashCode());
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testClone() {
        BooleanFieldFormat ff = new  BooleanFieldFormat();
        ff.setName("kek");
        ff.setDescription("lol");
        ff.setDefaultValue(true);
        ff.setHidden(false);
        ff.setNullable(false);
        BooleanFieldFormat  actual = (BooleanFieldFormat) ff.clone();
        assertEquals(ff, actual);

    }

    // convert to and from string
    //clone
    //hashcode equals
}
