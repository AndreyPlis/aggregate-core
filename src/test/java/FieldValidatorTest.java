import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldValidatorTest {
    @Test
    public void limitValidatorIntFieldFormat( ){
        IntFieldFormat iff = new IntFieldFormat( );
        iff.setValue(16788);
        iff.setName( "restDD" );
        iff.setHidden( false );
        assertEquals( false, FieldValidator.limitsValidator( iff, 1, 999 ) );
    }

    @Test
    public void limitValidatorStringFieldFormat( ){
        IntFieldFormat iff = new IntFieldFormat( );
        iff.setValue(16788);
        iff.setName( "restDD" );
        iff.setHidden( false );
        assertEquals( false, FieldValidator.limitsValidator( iff, 1, 999 ) );
    }

    @Test
    public void regexpValidator( ){
        FieldFormat bff = FieldFormatFactory.createFieldFormat( FieldFormat.BOOLEAN_FIELD, "test", "boolean field" );
        assertEquals( true, FieldValidator.regexpValidator( "^(true)$", bff.valueToString( true ) ) );
        assertEquals( false, FieldValidator.regexpValidator( "\\D*", "test1199" ) );
       //assertEquals( true, FieldValidator.regexpValidator( "\\D*", "test" ) );
    }

    @Test
    public void nullValidator( ){
        FieldFormat bff = FieldFormatFactory.createFieldFormat( FieldFormat.BOOLEAN_FIELD, "test", "boolean field" );
        assertEquals( true, FieldValidator.nullValidator( ( Boolean ) bff.getValue( ) ) );
        bff.setValue( false );
        assertEquals( false, FieldValidator.nullValidator( ( Boolean ) bff.getValue( ) ) );
    }
}
