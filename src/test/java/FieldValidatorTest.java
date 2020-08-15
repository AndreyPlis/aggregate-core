import com.tibbo.datatable.*;
import org.junit.*;

import static org.junit.Assert.*;

public class FieldValidatorTest {

    @Test
    public void limitValidatorIntFieldFormat( ){
        LimitsValidator lv = new LimitsValidator( 1, 4 );
        IntFieldFormat iff = new IntFieldFormat( );
        iff.setValue(16788);
        iff.setName( "restDD" );
        iff.setHidden( false );

        assertEquals( false, lv.validate( iff ) );
    }

    @Test
    public void regexpValidator( ){
        RegexpValidator rv = new RegexpValidator( "^(true)$" );
        FieldFormat bff = FieldFormatFactory.createFieldFormat( FieldFormat.BOOLEAN_FIELD, "test", "boolean field" );
        bff.setValue( true );
        assertEquals( true, rv.validate( bff ) );
    }

    @Test
    public void nullValidator( ){
        NullValidator nv = new NullValidator( );
        FieldFormat bff = FieldFormatFactory.createFieldFormat( FieldFormat.BOOLEAN_FIELD, "test", "boolean field" );
        assertEquals( true, nv.validate( bff ) );
        bff.setValue( false );
        assertEquals( false, nv.validate( bff ) );
    }
}
