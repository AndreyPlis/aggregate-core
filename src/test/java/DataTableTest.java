import com.tibbo.datatable.DataRecord;
import com.tibbo.datatable.SimpleDataTable;
import com.tibbo.datatable.TableFormat;
import com.tibbo.datatable.field.FieldFormat;
import com.tibbo.datatable.field.FieldFormatFactory;
import com.tibbo.datatable.validator.LimitsValidator;
import com.tibbo.datatable.validator.NonNullFieldValidator;
import org.junit.*;

public class DataTableTest {


    @Test
    public void sortDesc()
    {
        FieldFormat fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "ID", "Person ID", false, false, 0);
        FieldFormat fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "Name", "Person Name", false, false, "None");
        FieldFormat fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "SurName", "Person Surname", true, false, "None");
        FieldFormat fieldFormat3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "isWorking", "Info about Person work", true, false, null);
        FieldFormat fieldFormat4 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "Age", "Person Age", true, false, 0);

        LimitsValidator limitsValidator = new LimitsValidator(1, 9);
        NonNullFieldValidator nonNullFieldValidator = new NonNullFieldValidator();

        fieldFormat1.addValidator(limitsValidator);
        fieldFormat1.addValidator(nonNullFieldValidator);

        TableFormat tableFormat = new TableFormat();
        tableFormat.addField(fieldFormat);
        tableFormat.addField(fieldFormat1);
        tableFormat.addField(fieldFormat2);
        tableFormat.addField(fieldFormat3);
        tableFormat.addField(fieldFormat4);

        TableFormat tableFormatTest = new TableFormat();
        tableFormatTest.addField(fieldFormat);
        tableFormatTest.addField(fieldFormat1);
        tableFormatTest.addField(fieldFormat2);
        tableFormatTest.addField(fieldFormat3);
        tableFormatTest.addField(fieldFormat4);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("ID", 1);
        dataRecord.setValue("Name", "Pavel");
        dataRecord.setValue(2, "Demichev");
        dataRecord.setValue("isWorking", false);
        dataRecord.setValue("Age", 34);

        DataRecord dataRecord1 = new DataRecord(tableFormat);
        dataRecord1.setValue("ID", 2);
        dataRecord1.setValue("Name", "Dmitrii");
        dataRecord1.setValue(2, "Ivanov");
        dataRecord1.setValue("isWorking", true);
        dataRecord1.setValue("Age", 30);

        DataRecord dataRecord2 = new DataRecord(tableFormat);
        dataRecord2.setValue("ID", 3);
        dataRecord2.setValue("Name", "Alex");
        dataRecord2.setValue(2, "Ivanov");
        dataRecord2.setValue("isWorking", true);
        dataRecord2.setValue("Age", 31);

        DataRecord dataRecord3 = new DataRecord(tableFormat);
        dataRecord3.setValue("ID", 2);
        dataRecord3.setValue("Name", "Ivan");
        dataRecord3.setValue(2, "Demichev");
        dataRecord3.setValue("isWorking", true);
        dataRecord3.setValue("Age", 20);

        SimpleDataTable simpleDataTable = new SimpleDataTable(tableFormat);
        simpleDataTable.addRecord(dataRecord);
        simpleDataTable.addRecord(dataRecord1);
        simpleDataTable.addRecord(dataRecord2);
        simpleDataTable.addRecord(dataRecord3);

        SimpleDataTable simpleDataTableTest = new SimpleDataTable(tableFormatTest);
        simpleDataTableTest.addRecord(dataRecord3);
        simpleDataTableTest.addRecord(dataRecord1);
        simpleDataTableTest.addRecord(dataRecord2);
        simpleDataTableTest.addRecord(dataRecord);

        simpleDataTable.sort("Age", true);
         Assert.assertEquals(simpleDataTableTest,simpleDataTable );
    }

    @Test
    public void sortAsc()
    {
        FieldFormat fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "ID", "Person ID", false, false, 0);
        FieldFormat fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "Name", "Person Name", false, false, "None");
        FieldFormat fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "SurName", "Person Surname", true, false, "None");
        FieldFormat fieldFormat3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "isWorking", "Info about Person work", true, false, null);
        FieldFormat fieldFormat4 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "Age", "Person Age", true, false, 0);

        LimitsValidator limitsValidator = new LimitsValidator(1, 9);
        NonNullFieldValidator nonNullFieldValidator = new NonNullFieldValidator();

        fieldFormat1.addValidator(limitsValidator);
        fieldFormat1.addValidator(nonNullFieldValidator);

        TableFormat tableFormat = new TableFormat();
        tableFormat.addField(fieldFormat);
        tableFormat.addField(fieldFormat1);
        tableFormat.addField(fieldFormat2);
        tableFormat.addField(fieldFormat3);
        tableFormat.addField(fieldFormat4);

        TableFormat tableFormatTest = new TableFormat();
        tableFormatTest.addField(fieldFormat);
        tableFormatTest.addField(fieldFormat1);
        tableFormatTest.addField(fieldFormat2);
        tableFormatTest.addField(fieldFormat3);
        tableFormatTest.addField(fieldFormat4);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("ID", 1);
        dataRecord.setValue("Name", "Pavel");
        dataRecord.setValue(2, "Demichev");
        dataRecord.setValue("isWorking", false);
        dataRecord.setValue("Age", 34);

        DataRecord dataRecord1 = new DataRecord(tableFormat);
        dataRecord1.setValue("ID", 2);
        dataRecord1.setValue("Name", "Dmitrii");
        dataRecord1.setValue(2, "Ivanov");
        dataRecord1.setValue("isWorking", true);
        dataRecord1.setValue("Age", 30);

        DataRecord dataRecord2 = new DataRecord(tableFormat);
        dataRecord2.setValue("ID", 3);
        dataRecord2.setValue("Name", "Alex");
        dataRecord2.setValue(2, "Ivanov");
        dataRecord2.setValue("isWorking", true);
        dataRecord2.setValue("Age", 31);

        DataRecord dataRecord3 = new DataRecord(tableFormat);
        dataRecord3.setValue("ID", 2);
        dataRecord3.setValue("Name", "Ivan");
        dataRecord3.setValue(2, "Demichev");
        dataRecord3.setValue("isWorking", true);
        dataRecord3.setValue("Age", 20);

        SimpleDataTable simpleDataTable = new SimpleDataTable(tableFormat);
        simpleDataTable.addRecord(dataRecord);
        simpleDataTable.addRecord(dataRecord1);
        simpleDataTable.addRecord(dataRecord2);
        simpleDataTable.addRecord(dataRecord3);

        SimpleDataTable simpleDataTableTest = new SimpleDataTable(tableFormatTest);
        simpleDataTableTest.addRecord(dataRecord);
        simpleDataTableTest.addRecord(dataRecord2);
        simpleDataTableTest.addRecord(dataRecord1);
        simpleDataTableTest.addRecord(dataRecord3);

        simpleDataTable.sort("Age", false);
        Assert.assertEquals(simpleDataTableTest,simpleDataTable );
    }


    @Test
    public void filter()
    {
        FieldFormat fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "ID", "Person ID", false, false, 0);
        FieldFormat fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "Name", "Person Name", false, false, "None");
        FieldFormat fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "SurName", "Person Surname", true, false, "None");
        FieldFormat fieldFormat3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "isWorking", "Info about Person work", true, false, null);
        FieldFormat fieldFormat4 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "Age", "Person Age", true, false, 0);

        LimitsValidator limitsValidator = new LimitsValidator(1, 9);
        NonNullFieldValidator nonNullFieldValidator = new NonNullFieldValidator();

        fieldFormat1.addValidator(limitsValidator);
        fieldFormat1.addValidator(nonNullFieldValidator);

        TableFormat tableFormat = new TableFormat();
        tableFormat.addField(fieldFormat);
        tableFormat.addField(fieldFormat1);
        tableFormat.addField(fieldFormat2);
        tableFormat.addField(fieldFormat3);
        tableFormat.addField(fieldFormat4);

        TableFormat tableFormatTest = new TableFormat();
        tableFormatTest.addField(fieldFormat);
        tableFormatTest.addField(fieldFormat1);
        tableFormatTest.addField(fieldFormat2);
        tableFormatTest.addField(fieldFormat3);
        tableFormatTest.addField(fieldFormat4);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("ID", 1);
        dataRecord.setValue("Name", "Pavel");
        dataRecord.setValue(2, "Demichev");
        dataRecord.setValue("isWorking", false);
        dataRecord.setValue("Age", 34);

        DataRecord dataRecord1 = new DataRecord(tableFormat);
        dataRecord1.setValue("ID", 2);
        dataRecord1.setValue("Name", "Dmitrii");
        dataRecord1.setValue(2, "Ivanov");
        dataRecord1.setValue("isWorking", true);
        dataRecord1.setValue("Age", 30);

        DataRecord dataRecord2 = new DataRecord(tableFormat);
        dataRecord2.setValue("ID", 3);
        dataRecord2.setValue("Name", "Alex");
        dataRecord2.setValue(2, "Ivanov");
        dataRecord2.setValue("isWorking", true);
        dataRecord2.setValue("Age", 31);

        DataRecord dataRecord3 = new DataRecord(tableFormat);
        dataRecord3.setValue("ID", 2);
        dataRecord3.setValue("Name", "Ivan");
        dataRecord3.setValue(2, "Demichev");
        dataRecord3.setValue("isWorking", true);
        dataRecord3.setValue("Age", 20);

        SimpleDataTable simpleDataTable = new SimpleDataTable(tableFormat);
        simpleDataTable.addRecord(dataRecord);
        simpleDataTable.addRecord(dataRecord1);
        simpleDataTable.addRecord(dataRecord2);
        simpleDataTable.addRecord(dataRecord3);

        SimpleDataTable simpleDataTableTest = new SimpleDataTable(tableFormatTest);
        simpleDataTableTest.addRecord(dataRecord);

        Assert.assertEquals(simpleDataTableTest, simpleDataTable.filter("Name", "Pavel"));
    }
}
