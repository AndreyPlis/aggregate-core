package com.tibbo.datatable;

public class DataRecord<T> {
    private FieldFormat fieldFormat;
    private T data;
    private FieldValidator fieldValidator;
    public DataRecord( T data, FieldFormat fieldFormat, FieldValidator fieldValidator )
    {
        this.data = data;
        this.fieldFormat = fieldFormat;
        this.fieldValidator = fieldValidator;
    }

}
