import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;


public class TableFormatTest {

    @Test
    public void checkCloneMethod() {
        TableFormat tableFormatOriginal = new TableFormat(15, 10);
        TableFormat tableFormatClone = tableFormatOriginal.clone();

        assertEquals(tableFormatClone, tableFormatOriginal);
        assertEquals(tableFormatClone.getMaxCountField(), tableFormatOriginal.getMaxCountField());
        assertEquals(tableFormatClone.getMinCountField(), tableFormatOriginal.getMinCountField());
    }

    @Test
    public void checkEqualsMethod() {
        TableFormat tableFormatOriginal = new TableFormat(15, 10);
        TableFormat tableFormat = new TableFormat(15, 10);
        FieldFormat<String> fieldFormat = new StringFieldFormat();
        assertEquals(tableFormat, tableFormatOriginal);
        tableFormatOriginal.addField(fieldFormat);
        tableFormat.setMinCountField(25);

        assertNotEquals(tableFormat, tableFormatOriginal);
    }

    @Test
    public void checkHashCodeMethod() {
        TableFormat tableFormatOriginal = new TableFormat(15, 10);
        FieldFormat<String> stringFieldFormat1 = new StringFieldFormat();
        TableFormat tableFormat = new TableFormat(15, 10);

        assertEquals(tableFormatOriginal.hashCode(), tableFormat.hashCode());
        tableFormat.addField(stringFieldFormat1);
        tableFormat.setMinCountField(25);
        assertNotEquals(tableFormatOriginal.hashCode(), tableFormat.hashCode());
    }
}

