import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldValidatorTest {
    @Test
    public void limitValidator( ){
        IntFieldFormat iff = new IntFieldFormat( );
        iff.setValue(16788);
        iff.setName( "restDD" );
        iff.setHidden( false );
        assertEquals( false, FieldValidator.limitsValidator( iff, 1, 999 ) );
    }
}
