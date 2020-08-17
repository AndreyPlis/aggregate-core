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
    }

    @Test
    public void createIntFieldFormatFromFactory() {

    }

    // convert to and from string
    //clone
    //hashcode equals
}
