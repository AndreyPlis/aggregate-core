import com.tibbo.datatable.*;


public class Main {

    public static void main(String[] args) {
        FieldFormat<?> fieldFormat = FieldFormatFactory.createFieldFormat(FieldFormat.INTEGER_FIELD, "Alex", "One", false);
        System.out.println(fieldFormat.getName());
        System.out.println(fieldFormat.getDescription());
        System.out.println(fieldFormat.getNullable());

    }
}
