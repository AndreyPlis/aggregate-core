import javax.swing.text.html.*;

import com.tibbo.datatable.*;
import com.tibbo.datatable.field.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DataTableTest {


    @Test
    public void sortDesc()
    {

        FieldFormat ff1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,
                "name", "Someone name");
        assertEquals("name", ff1.getName());

        FieldFormat ff2 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "age");
        FieldFormat ff3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "haveJob");
        TableFormat tf = new TableFormat(0, 10);
        tf.addField(ff1);
        tf.addField(ff2);
        tf.addField(ff3);
        assertEquals("name", tf.getField(0).getName());

        DataRecord dataRecord1 = new DataRecord(tf);
        dataRecord1.setValue("name", "Bob");
        dataRecord1.setValue("age", 25);
        dataRecord1.setValue("haveJob", true);
        DataRecord dataRecord2 = new DataRecord(tf);
        dataRecord2.setValue("name", "Silvia");
        dataRecord2.setValue("age", 20);
        dataRecord2.setValue("haveJob", false);
        DataRecord dataRecord3 = new DataRecord(tf);
        dataRecord3.setValue("name", "Amanda");
        dataRecord3.setValue("age", 1);
        dataRecord3.setValue("haveJob", false);
        DataRecord dataRecord4 = new DataRecord(tf);
        dataRecord4.setValue("name", "Muzzy");
        dataRecord4.setValue("age", 136);
        dataRecord4.setValue("haveJob", true);
        DataTable dataTable = new SimpleDataTable(tf);
        dataTable.addRecord(dataRecord1);
        dataTable.addRecord(dataRecord2);
        dataTable.addRecord(dataRecord4);
        dataTable.addRecord(dataRecord3);
        assertEquals("Amanda", dataTable.getCellValue("name", 3));
        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }

        dataTable.sort("name", true);
        System.out.println("---------------- Sorted data table. ---------------------");
        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }
        assertEquals("Silvia", dataTable.getCellValue("name", 3));

    }

    @Test
    public void sortAsc()
    {
        FieldFormat ff1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,
                "name", "Someone name");
        FieldFormat ff2 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "age");
        FieldFormat ff3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "haveJob");
        TableFormat tf = new TableFormat(0, 10);
        tf.addField(ff1);
        tf.addField(ff2);
        tf.addField(ff3);
        DataRecord dataRecord1 = new DataRecord(tf);
        dataRecord1.setValue("name", "Bob");
        dataRecord1.setValue("age", 25);
        dataRecord1.setValue("haveJob", true);
        DataRecord dataRecord2 = new DataRecord(tf);
        dataRecord2.setValue("name", "Silvia");
        dataRecord2.setValue("age", 20);
        dataRecord2.setValue("haveJob", false);
        DataRecord dataRecord3 = new DataRecord(tf);
        dataRecord3.setValue("name", "Amanda");
        dataRecord3.setValue("age", 1);
        dataRecord3.setValue("haveJob", false);
        DataRecord dataRecord4 = new DataRecord(tf);
        dataRecord4.setValue("name", "Muzzy");
        dataRecord4.setValue("age", 136);
        dataRecord4.setValue("haveJob", true);
        DataTable dataTable = new SimpleDataTable(tf);
        dataTable.addRecord(dataRecord1);
        dataTable.addRecord(dataRecord2);
        dataTable.addRecord(dataRecord4);
        dataTable.addRecord(dataRecord3);

        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }
        dataTable.sort("age", false);
        System.out.println("---------------- Sorted data table. ---------------------");
        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }
    }


    @Test void filter()
    {
        FieldFormat ff1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,
                "name", "Someone name");
        FieldFormat ff2 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "age");
        FieldFormat ff3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "haveJob");
        TableFormat tf = new TableFormat(0, 10);
        tf.addField(ff1);
        tf.addField(ff2);
        tf.addField(ff3);
        DataRecord dataRecord1 = new DataRecord(tf);
        dataRecord1.setValue("name", "Bob");
        dataRecord1.setValue("age", 25);
        dataRecord1.setValue("haveJob", true);
        DataRecord dataRecord2 = new DataRecord(tf);
        dataRecord2.setValue("name", "Silvia");
        dataRecord2.setValue("age", 20);
        dataRecord2.setValue("haveJob", false);
        DataRecord dataRecord3 = new DataRecord(tf);
        dataRecord3.setValue("name", "Amanda");
        dataRecord3.setValue("age", 1);
        dataRecord3.setValue("haveJob", false);
        DataRecord dataRecord4 = new DataRecord(tf);
        dataRecord4.setValue("name", "Muzzy");
        dataRecord4.setValue("age", 136);
        dataRecord4.setValue("haveJob", true);
        DataTable dataTable = new SimpleDataTable(tf);
        dataTable.addRecord(dataRecord1);
        dataTable.addRecord(dataRecord2);
        dataTable.addRecord(dataRecord4);
        dataTable.addRecord(dataRecord3);

        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }
        dataTable.filter("haveJob", true);
        System.out.println("---------------- Sorted data table. ---------------------");
        for(int i=0; i<dataTable.getRecordsCount(); i++){
            DataRecord dr = dataTable.getRecord(i);
            System.out.println(i + ": " + dr.getValue("name")+", "+ dr.getValue("age") + ", " +
                    dr.getValue("haveJob"));
        }
    }
}
