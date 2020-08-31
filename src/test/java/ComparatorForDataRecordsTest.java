import com.tibbo.datatable.DataRecord;
import com.tibbo.datatable.SimpleDataTable;
import com.tibbo.datatable.TableFormat;
import com.tibbo.datatable.field.FieldFormatFactory;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComparatorForDataRecordsTest  {
    @Test
    public void sortTest(){
       TableFormat tableFormat = new TableFormat(0, 1000);

        tableFormat.addField(FieldFormatFactory.createFieldFormat('I', "age", "age",true, 18 ));
        tableFormat.addField(FieldFormatFactory.createFieldFormat('S', "name", "name human",true, "18" ));
        tableFormat.addField(FieldFormatFactory.createFieldFormat('B', "isLife", "human is lise?",true, true ));

        SimpleDataTable dataTable = new SimpleDataTable(tableFormat);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("age", 34);
        dataRecord.setValue("name", "Ilya");
        dataRecord.setValue("isLife", true);

        DataRecord dataRecord_1 = new DataRecord(tableFormat);
     dataRecord_1.setValue("age", 23);
     dataRecord_1.setValue("name", "Kate");
     dataRecord_1.setValue("isLife", false);

        DataRecord dataRecord_2 = new DataRecord(tableFormat);
     dataRecord_2.setValue("age", 12);
     dataRecord_2.setValue("name", "Michael");
     dataRecord_2.setValue("isLife", true);

        dataTable.addRecord(dataRecord);
        dataTable.addRecord(dataRecord_1);
        dataTable.addRecord(dataRecord_2);


        SimpleDataTable data = new SimpleDataTable(tableFormat);
     data.addRecord(dataRecord);
     data.addRecord(dataRecord_2);
     data.addRecord(dataRecord_1);

       data.sort("age", false);
        assertEquals(dataTable, data);
    }

    @Test
    public void filterTest(){

        TableFormat tableFormat = new TableFormat(0, 1000);

        tableFormat.addField(FieldFormatFactory.createFieldFormat('I', "age", "age",true, 18 ));
        tableFormat.addField(FieldFormatFactory.createFieldFormat('S', "name", "name human",true, "18" ));
        tableFormat.addField(FieldFormatFactory.createFieldFormat('B', "isLife", "human is lise?",true, true ));

        SimpleDataTable dataTable = new SimpleDataTable(tableFormat);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("age", 34);
        dataRecord.setValue("name", "Ilya");
        dataRecord.setValue("isLife", true);

        DataRecord dataRecord_1 = new DataRecord(tableFormat);
        dataRecord_1.setValue("age", 23);
        dataRecord_1.setValue("name", "Kate");
        dataRecord_1.setValue("isLife", false);

        DataRecord dataRecord_2 = new DataRecord(tableFormat);
        dataRecord_2.setValue("age", 12);
        dataRecord_2.setValue("name", "Michael");
        dataRecord_2.setValue("isLife", true);

        dataTable.addRecord(dataRecord);
        dataTable.addRecord(dataRecord_1);
        dataTable.addRecord(dataRecord_2);

        SimpleDataTable data = new SimpleDataTable(tableFormat);
        data.addRecord(dataRecord_2);

        dataTable = (SimpleDataTable) dataTable.filter("name", "Michael");
        assertEquals(dataTable, data);


    }

}