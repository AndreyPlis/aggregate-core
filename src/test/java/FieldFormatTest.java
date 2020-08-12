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
        FieldFormat ff = FieldFormatFactory.createFieldFormat( FieldFormat.STRING_FIELD, "test", "string field" );
        assertEquals(FieldFormat.STRING_FIELD,ff.getType());
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
    //clone
    public void cloneIntFieldFormat( ){
        IntFieldFormat ff = new IntFieldFormat();
        ff.setName( "name" );
        ff.setDescription( "Integer field" );

        //assertEquals(, ff. );
    }
    @Test
    public void hashCodeAndEqualsIntFieldFormat( ){
        IntFieldFormat ff = new IntFieldFormat();
        ff.setName( "name" );
        ff.setDescription( "Integer field" );
        //assertEquals( 1, ff.hashCode( ) );
        assertEquals( true, ff.equals( ff ) );
    }
}
