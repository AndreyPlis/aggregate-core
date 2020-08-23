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
        FieldFormat ff1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "test", "string field", false, false, "test");
        assertEquals(FieldFormat.STRING_FIELD,ff1.getType());
    }

    @Test
    public void createIntFieldFormatFromFactory() {
        FieldFormat ff = FieldFormatFactory.createFieldFormat( FieldFormat.INTEGER_FIELD, "test1", "Integer field" );
        assertEquals( FieldFormat.INTEGER_FIELD, ff.getType( ) );
    }

    @Test
    public void convertToAndFromStringStringFieldFormat( ){
        FieldFormat ff = FieldFormatFactory.createFieldFormat( FieldFormat.INTEGER_FIELD, "test", "string field" );
        assertEquals(1234, ff.valueFromString( "1234" ) );
        assertEquals("1234", ff.valueToString( 1234 ) );
    }

    @Test
    public void hashCodeAndEqualsIntFieldFormat( ){
        IntFieldFormat ff1 = new IntFieldFormat();
        ff1.setName( "name" );
        ff1.setDescription( "Integer field" );
        IntFieldFormat ff2 = new IntFieldFormat();
        ff2.setName( "name" );
        ff2.setDescription( "Integer field" );
        assertEquals( true, ff1.equals( ff2 ) && ff2.equals( ff1 ) );
        assertEquals( true, ff1.hashCode( ) == ff2.hashCode( ) );
    }
}
