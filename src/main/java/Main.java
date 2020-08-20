import com.tibbo.datatable.*;


public class Main {

    public static void main(String[] args) {
        FieldFormat<?> fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "ID", "Serial number", false);
        FieldFormat<?> fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "Name", "Person name", false);
        FieldFormat<?> fieldFormat3 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD, "SurName", "Person Surname", true);
        FieldFormat<?> fieldFormat4 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD, "IsWorking", "info about person job", false);
        FieldFormat<?> fieldFormat5 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "Age", "Person Age", false);

        TableFormat tableFormat = new TableFormat();
        tableFormat.addField(fieldFormat1);
        tableFormat.addField(fieldFormat2);
        tableFormat.addField(fieldFormat3);
        tableFormat.addField(fieldFormat4);
        tableFormat.addField(fieldFormat5);

        NullFieldValidator<?> nullFieldValidator = new NullFieldValidator<>();
        LengthFieldValidator<?> lengthFieldValidator = new LengthFieldValidator<>(8);

        fieldFormat2.addValidator(nullFieldValidator);
        fieldFormat2.addValidator(lengthFieldValidator);

        DataRecord dataRecord = new DataRecord();
        dataRecord.addDataToList(tableFormat,0,"1");
        dataRecord.addDataToList(tableFormat,1,"Dmitrii");

        System.out.println(dataRecord);
        dataRecord.changeDataList(tableFormat,1,"Alex");
        System.out.println(dataRecord);


    }
}
