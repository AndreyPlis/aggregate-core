package com.tibbo.datatable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator extends Validators {

    @Override
    public <T> void nullFieldValidator(T value) {
        if (value == null)
            throw new NullPointerException("Значение не может быть равно нулю");
    }

    @Override
    public void limitsValidator(int value) {
        int startValueLimits = 10;
        int endValueLimits = 20;
        if (value <= startValueLimits || value >= endValueLimits) {
            throw new IllegalArgumentException(String.format("Значение должно быть в диапазоне от %d до %d", startValueLimits, endValueLimits));
        }
    }

    @Override
    public void regexValidation(String value) {
        Pattern regex = Pattern.compile("\\A-Z{1}[a-z]+");
        Matcher matcher = regex.matcher(value);
        if (!matcher.find())
            throw new IllegalArgumentException("Строка не соответствует шаблону");
    }

    @Override
    public void lengthFieldValidator(String value) {
        int lengthField = 50;
        if (value.length() < lengthField)
            throw new IllegalArgumentException("Превышение количества символов");
    }
}
