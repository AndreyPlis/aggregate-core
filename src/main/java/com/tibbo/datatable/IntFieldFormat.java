package com.tibbo.datatable;

public class IntFieldFormat extends FieldFormat<Integer> {
    char typeField = INTEGER_FIELD;

    @Override
    public String valueToString(Integer value) {
        return value.toString();

    }

    @Override
    public Integer valueFromString(String value) {
        Integer tmp = null;
        try
        {
           tmp = Integer.parseInt (value);

        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return tmp;
    }


    @Override
    public char getType() {
        return typeField;
    }

    @Override
    public FieldFormat clone() {
        IntFieldFormat tmp = new IntFieldFormat();
        tmp.setName(this.getName());
        tmp.setDescription(this.getDescription());
        tmp.setNullable(this.getNullable());
        tmp.setHidden(this.getHidden());
        tmp.setDefaultValue(this.getDefaultValue());
        return tmp;



    }
}
