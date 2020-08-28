package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord {

    private TableFormat tableFormat;

    private Map<String,Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    private void validAndPutValue( Object value, int index, String fieldName )
    {
        FieldFormat ff = null;
        if( !fieldName.isEmpty() ){
            ff = findField( fieldName );
        }
        if( index > 0 ){
            ff = findField( index );
        }
        if ( ff == null )
            throw new NullPointerException( "Пустой Филд" );
        ff.validate( value );
        data.put(ff.getName(), value);
    }

    public void setValue(String fieldName, Object value)
    {
        validAndPutValue( value, 0, fieldName );
    }

    public void setValue(int index, Object value)
    {
        validAndPutValue( value, index, "" );
    }

    public Object getValue(int index)
    {
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName)
    {
        return data.get(fieldName);
    }

    private FieldFormat findField(int index)
    {
        return tableFormat.getField(index);
    }

    private FieldFormat findField( String fieldName )
    {
        return tableFormat.getField( fieldName );
    }
}
