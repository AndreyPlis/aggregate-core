import com.tibbo.datatable.DataRecord;
import com.tibbo.datatable.SimpleDataTable;
import com.tibbo.datatable.TableFormat;
import com.tibbo.datatable.field.FieldFormat;
import com.tibbo.datatable.field.FieldFormatFactory;
import com.tibbo.datatable.validator.FieldValidator;
import com.tibbo.datatable.validator.LimitsValidator;
import com.tibbo.datatable.validator.NonNullFieldValidator;
import org.junit.*;

import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;

public class DataTableTest {


    @Test
    public void sortDesc()
    {

    }

    @Test
    public void sortAsc()
    {

    }


    @Test
    public void filter()
    {
        FieldValidator nullValidator = new NonNullFieldValidator();
        FieldValidator limitsValidator = new LimitsValidator( 1, 500 );

        FieldFormat stringFormat = FieldFormatFactory.createFieldFormat( FieldFormat.STRING_FIELD, "Desc" );
        stringFormat.addValidator( nullValidator );
        stringFormat.addValidator( limitsValidator );

        FieldFormat intFormat = FieldFormatFactory.createFieldFormat( FieldFormat.INTEGER_FIELD, "Счёт" );
        intFormat.addValidator( nullValidator );
        intFormat.addValidator( limitsValidator );

        FieldFormat boolFormat = FieldFormatFactory.createFieldFormat( FieldFormat.BOOLEAN_FIELD, "Пустой" );
        boolFormat.addValidator( nullValidator );
        boolFormat.addValidator( limitsValidator );

        TableFormat tableFormat = new TableFormat( );
        tableFormat.setMaxRecords(5);
        tableFormat.setMinRecords(1);
        tableFormat.addField( stringFormat );
        tableFormat.addField( intFormat );
        tableFormat.addField( boolFormat );


        DataRecord record1 = new DataRecord( tableFormat );
        record1.setValue( "Desc", "Machine" );
        record1.setValue( "Счёт", 2 );
        //record1.setValue( "Пустой", false );

        DataRecord record2 = new DataRecord( tableFormat );
        record2.setValue( "Desc", "Bycicle" );
        record2.setValue( "Счёт", 8 );
        //record2.setValue( "Пустой", false );

        DataRecord record3 = new DataRecord( tableFormat );
        record3.setValue( "Desc", "Machine" );
        record3.setValue( "Счёт", 5 );
        //record3.setValue( "Пустой", true );


        SimpleDataTable simpleDataTable = new SimpleDataTable( tableFormat );
        simpleDataTable.addRecord( record1 );
        simpleDataTable.addRecord( record2 );
        simpleDataTable.addRecord( record3 );



        SimpleDataTable simpleDataTable1 = new SimpleDataTable( tableFormat );
        simpleDataTable1.addRecord( record1 );
        simpleDataTable1.addRecord( record3 );
        assertEquals( simpleDataTable1, simpleDataTable.filter( "Desc", "Machine" ) );
    }
}
