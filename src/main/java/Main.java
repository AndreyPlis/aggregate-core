import com.tibbo.datatable.*;


public class Main {

    public static void main(String[] args) {
        FieldFormat<?> fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.STRING_FIELD,"Alex",null,null,null,"One");
        TableFormat tableFormat = new TableFormat(15,25);
        String number = null;
        //nullFieldValidator(fieldFormat.getName());
        //limitsValidator(tableFormat.getMinCountField());
        System.out.println(fieldFormat.getName());
        System.out.println(fieldFormat.getDefaultValue());
        FieldFormat<?> fieldFormat1 = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD);
        fieldFormat1.setName("Bob");
        System.out.println(fieldFormat1.getName());


    }
}
