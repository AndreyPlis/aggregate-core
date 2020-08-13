import com.tibbo.datatable.FieldFormat;
import com.tibbo.datatable.FieldValidator;
import com.tibbo.datatable.StringFieldFormat;

public class Main {

    public static void main(String[] args) {
        FieldValidator fieldValidator = new FieldValidator();
        FieldFormat<?> fieldFormat = new StringFieldFormat();
        fieldFormat.setName("One");
        fieldFormat.setHidden(false);
        fieldValidator.Validation(fieldFormat);
    }
}
