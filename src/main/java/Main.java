import com.tibbo.datatable.*;
import com.tibbo.datatable.field.FieldFormat;
import com.tibbo.datatable.field.FieldFormatFactory;
import com.tibbo.datatable.validator.LimitsValidator;
import com.tibbo.datatable.validator.NonNullFieldValidator;

import javax.xml.crypto.Data;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        FieldFormat fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD,"ID", "Person ID", false, false, 0);
        FieldFormat fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,"Name", "Person Name", false, false, "None");
        FieldFormat fieldFormat2 = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,"SurName", "Person Surname", true, false, "None");
        FieldFormat fieldFormat3 = FieldFormatFactory.createFieldFormat(FieldFormat.BOOLEAN_FIELD,"isWorking", "Info about Person work", true, false, null);
        FieldFormat fieldFormat4 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD,"Age", "Person Age", true, false, 0);

        LimitsValidator limitsValidator = new LimitsValidator(1,9);
        NonNullFieldValidator nonNullFieldValidator = new NonNullFieldValidator();

        fieldFormat1.addValidator(limitsValidator);
        fieldFormat1.addValidator(nonNullFieldValidator);

        TableFormat tableFormat = new TableFormat();
        tableFormat.addField(fieldFormat);
        tableFormat.addField(fieldFormat1);
        tableFormat.addField(fieldFormat2);
        tableFormat.addField(fieldFormat3);
        tableFormat.addField(fieldFormat4);

        DataRecord dataRecord = new DataRecord(tableFormat);
        dataRecord.setValue("ID",1);
        dataRecord.setValue("Name", "Dmitrii");
        dataRecord.setValue(2, "Demichev");
        dataRecord.setValue("isWorking", true);
        dataRecord.setValue("Age", 34);

        DataRecord dataRecord1 = dataRecord.clone();
        System.out.println(dataRecord);
        System.out.println(dataRecord1);
        System.out.println(dataRecord.equals(dataRecord1));
        System.out.println("--------------------------------------------------");

        dataRecord.setValue("Name", "Alex");
        System.out.println(dataRecord);
        System.out.println(dataRecord1);
        System.out.println(dataRecord.equals(dataRecord1));
        System.out.println("--------------------------------------------------");

        dataRecord1.setValue("Name", "Alex");
        System.out.println(dataRecord);
        System.out.println(dataRecord1);
        System.out.println(dataRecord.equals(dataRecord1));
        System.out.println("--------------------------------------------------");

    }
}
