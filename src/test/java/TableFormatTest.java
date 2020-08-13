import com.tibbo.datatable.*;
import org.junit.*;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.*;


public class TableFormatTest {
    private final TableFormat tableFormatOriginal = new TableFormat(15, 10);

    @Test
    public void checkCloneMethod() {
        TableFormat tableFormatClone = tableFormatOriginal.clone();

        assertEquals(tableFormatClone, tableFormatOriginal);
        assertEquals(tableFormatClone.getMaxCountField(), tableFormatOriginal.getMaxCountField());
        assertEquals(tableFormatClone.getMinCountField(), tableFormatOriginal.getMinCountField());
    }

    @Test
    public void checkEqualsMethod() {
        TableFormat tableFormat = new TableFormat(15, 10);
        FieldFormat<String> fieldFormat = new StringFieldFormat();
        assertEquals(tableFormat, tableFormatOriginal);
        tableFormatOriginal.addField(fieldFormat);
        tableFormat.setMinCountField(25);

        assertNotEquals(tableFormat, tableFormatOriginal);

    }

    @Test
    public void checkHashCodeMethod() {
        FieldFormat<String> stringFieldFormat1 = new StringFieldFormat();
        TableFormat tableFormat = new TableFormat(15, 10);

        assertEquals(tableFormatOriginal.hashCode(), tableFormat.hashCode());
        tableFormat.addField(stringFieldFormat1);
        tableFormat.setMinCountField(25);
        assertNotEquals(tableFormatOriginal.hashCode(), tableFormat.hashCode());

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
        JUnitCore coreTable = new JUnitCore();
        coreTable.addListener(new CalcListenerTableFormat());
        coreTable.run(TableFormatTest.class);

    }
}

class CalcListenerTableFormat extends RunListener {
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
